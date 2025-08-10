// Time Complexity : O(m), where m is the number of houses (since we calculate cost for each house exactly once in DP).
// Space Complexity : O(m), due to the dp array storing results for each house and each color.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Initially had a typo in initializing dp[0] values (overwriting dp[0][0]).
// Fixed it by assigning correct costs for all colors for the first house.
//
// Your code here along with comments explaining your approach:
// This problem asks for the minimum cost to paint all houses such that no two adjacent houses have the same color.
// We use Dynamic Programming:
// - dp[i][c] = minimum cost to paint houses from 0 to i, with house i painted color c.
// - Transition: dp[i][c] = cost[i][c] + min(dp[i-1][otherColors])
// - Base case: dp[0][c] = cost[0][c] for c in {0, 1, 2}.
// The final answer is min(dp[m-1][0], dp[m-1][1], dp[m-1][2]).

public class MinCost {

    public int minCost(int[][] costs) {
        int m = costs.length;
        int n = costs[0].length;

        // Edge case: No houses
        if (m == 0) return 0;

        int[][] dp = new int[m][n];
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];

        for (int i = 1; i < m; i++) {
            dp[i][0] = costs[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }

        return Math.min(dp[m - 1][0], Math.min(dp[m - 1][1], dp[m - 1][2]));
    }

    // Recursive approach (kept as is for ref)
    public int minCost1(int[][] costs) {
        int r = helper(costs, 0, 0, 0);
        int g = helper(costs, 0, 1, 0);
        int b = helper(costs, 0, 2, 0);

        return Math.min(r, Math.min(g, b));
    }

    public int helper(int[][] costs, int index, int color, int result) {
        if (index == costs.length) {
            return result;
        }

        if (color == 0) {
            return Math.min(helper(costs, index + 1, 1, result + costs[index][1]),
                    helper(costs, index + 1, 2, result + costs[index][2]));
        } else if (color == 1) {
            return Math.min(helper(costs, index + 1, 0, result + costs[index][0]),
                    helper(costs, index + 1, 2, result + costs[index][2]));
        } else if (color == 2) {
            return Math.min(helper(costs, index + 1, 0, result + costs[index][0]),
                    helper(costs, index + 1, 1, result + costs[index][1]));
        }
        return -1;
    }

    // Main method with additional edge cases
    public static void main(String[] args) {
        MinCost cost = new MinCost();

        // Original case
        int[][] costs1 = {{17, 2, 17}, {16, 16, 5}, {14, 3, 19}};
        System.out.println("Min cost (DP): " + cost.minCost(costs1));

        // Single house
        int[][] costs2 = {{5, 10, 3}};
        System.out.println("Single house: " + cost.minCost(costs2));

        // No houses
        int[][] costs3 = {};
        System.out.println("No houses: " + cost.minCost(costs3));

        // Two houses with equal costs
        int[][] costs4 = {{1, 1, 1}, {1, 1, 1}};
        System.out.println("Two houses equal costs: " + cost.minCost(costs4));

        // All high costs except one cheap path
        int[][] costs5 = {{100, 100, 1}, {100, 1, 100}, {1, 100, 100}};
        System.out.println("Cheap diagonal path: " + cost.minCost(costs5));
    }
}