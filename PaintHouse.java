
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach
// Time Complexity : O(n)
// Space Complexity : O(1)

// This problem we have to give the min cost for painting the house
// We cannot have adjacent houses painted with the same color
// Greedy doesnt work for this approach
// if we choose to paint a house with one color other two colors should be chosen to paint the other house
// we can use dp for this
// first approach mutates the given input array

class Solution {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0)
            return 0;
        int n = costs.length;

        for (int i = n - 2; i >= 0; i--) {
            costs[i][0] = costs[i][0] + Math.min(costs[i + 1][1], costs[i + 1][2]);
            costs[i][1] = costs[i][1] + Math.min(costs[i + 1][0], costs[i + 1][2]);
            costs[i][2] = costs[i][2] + Math.min(costs[i + 1][0], costs[i + 1][1]);
        }

        return Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2]));
    }
}

// Approach 2

// Time Complexity : O(n)
// Space Complexity : O(n)

// Second approach uses a dp array instead of mutating the given input array

class Solution {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0)
            return 0;
        int n = costs.length;
        int[][] dp = new int[n][3];
        for (int i = 0; i < 3; i++)
            dp[n - 1][i] = costs[n - 1][i];
        for (int i = n - 2; i >= 0; i--) {
            dp[i][0] = costs[i][0] + Math.min(dp[i + 1][1], dp[i + 1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i + 1][0], dp[i + 1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i + 1][0], dp[i + 1][1]);
        }
        return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
    }
}