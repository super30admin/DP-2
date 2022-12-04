// Exhaustive recurssive solution
// Time Complexity : O(3 * 2^n) -> O(2^n), n levels,
// Space Complexity : O(2^n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Exhaustive recusrsive approach
class Solution {
    public int minCost(int[][] costs) {

        // check null case
        if (costs == null || costs.length == 0)
            return 0;

        // call 3 helper functionf or 3 different columns.
        int caseR = helper(costs, 0, 0, 0);
        int caseG = helper(costs, 0, 1, 0);
        int caseB = helper(costs, 0, 2, 0);

        // return the minimum cost amoung the 3 paths
        return Math.min(caseR, Math.min(caseG, caseB));
    }

    private int helper(int[][] costs, int index, int color, int minCost) {
        // base case
        if (index == costs.length)
            return minCost;

        // according to the color, do the recursive call to select the minimum cost from
        // remaining colors
        if (color == 0) {
            return Math.min(helper(costs, index + 1, 1, minCost + costs[index][0]),
                    helper(costs, index + 1, 2, minCost + costs[index][0]));
        }
        if (color == 1) {
            return Math.min(helper(costs, index + 1, 0, minCost + costs[index][1]),
                    helper(costs, index + 1, 2, minCost + costs[index][1]));
        }
        if (color == 2) {
            return Math.min(helper(costs, index + 1, 0, minCost + costs[index][2]),
                    helper(costs, index + 1, 1, minCost + costs[index][2]));
        }

        return 98897969;
    }
}

// Time Complexity : O(mn) -> O(3n) -> O(n), m and n is length of coins array,
// Space Complexity : O(mn) -> O(3n) -> O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
/*
 * The exhaustive recursive solution gave a time limit excess -> reduced the
 * extra calculations by using DP
 */

class Solution {
    public int minCost(int[][] costs) {

        int m = costs.length;
        // create a new dp array to store the cost per color.
        int[][] dp = new int[m][3];

        // the last row would be the same, so copy last row to dp array.
        dp[m - 1][0] = costs[m - 1][0];
        dp[m - 1][1] = costs[m - 1][1];
        dp[m - 1][2] = costs[m - 1][2];

        // for every previous row, check the the sum up the cost of that row, column and
        // take minimum of remainign 2 columns from next row.
        for (int i = m - 2; i >= 0; i--) {
            dp[i][0] = costs[i][0] + Math.min(dp[i + 1][1], dp[i + 1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i + 1][0], dp[i + 1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i + 1][0], dp[i + 1][1]);
        }

        // return minimum amoung the row 0.
        return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
    }
}