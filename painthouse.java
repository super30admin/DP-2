// Time Complexity : O(m*n) where m is the number of houses and n is the number of colors.
// Space Complexity : O(m*n) for the DP table.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : the correct mapping of colors to houses.
// Your code here along with comments explaining your approach: create dp table of size m*n where m is the number of houses and n is the number of colors. The value at dp[i][j] will represent the minimum cost to paint house i with color j. The cost to paint house i with color j will be the cost of painting house i with color j plus the minimum cost of painting house i-1 with a different color. Finally, return the minimum cost to paint all houses which will be the minimum value in the last row of the dp table.

class Solution {
    public int minCost(int[][] costs) {
        int m = costs.length;
        int n = costs[0].length;

        int[][] dp = new int[m][n];

        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];

        for(int i = 1; i < m; i++) {
            dp[i][0] = costs[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
        }

        return Math.min(dp[m-1][0], Math.min(dp[m-1][1], dp[m-1][2]));
    }
}
