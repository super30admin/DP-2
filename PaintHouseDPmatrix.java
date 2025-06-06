// Time Complexity : O(n), where n is the number of houses
// Space Complexity : O(n), due to the dp 2D array used
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach:
// This is a bottom-up dynamic programming approach to solve the "Paint House" problem.
// We use DP matrix
// We fill the dp table from the bottom row (last house) up to the top.
// At each house, we compute the minimum cost of painting it with each color,
// by adding the current painting cost to the minimum of the next house's available color costs (excluding the current).
// The final answer is the minimum value from the first house's three color options.

class Solution {
    public int minCost(int[][] costs) {
        int m = costs.length;
        int n = costs[0].length;

        // Create a dp table of same dimensions
        int[][] dp = new int[m][n];

        // Initialize the last row with the cost of painting the last house
        dp[m - 1][0] = costs[m - 1][0]; // Red
        dp[m - 1][1] = costs[m - 1][1]; // Blue
        dp[m - 1][2] = costs[m - 1][2]; // Green

        // Fill the dp table in bottom-up manner
        for (int i = m - 2; i >= 0; i--) {
            // Cost to paint current house Red = current cost + min(previous house Blue or Green)
            dp[i][0] = costs[i][0] + Math.min(dp[i + 1][1], dp[i + 1][2]);

            // Cost to paint current house Blue = current cost + min(previous house Red or Green)
            dp[i][1] = costs[i][1] + Math.min(dp[i + 1][0], dp[i + 1][2]);

            // Cost to paint current house Green = current cost + min(previous house Red or Blue)
            dp[i][2] = costs[i][2] + Math.min(dp[i + 1][0], dp[i + 1][1]);
        }

        // Return the minimum of the three options for the first house
        return Math.min(Math.min(dp[0][0], dp[0][1]), dp[0][2]);
    }
}
