// Time Complexity : O(n); n = costs.length
// Space Complexity : 0(n); since O(n * 3) = O(n)
// Did this code successfully run on Leetcode : Yes
class Solution {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0 || costs[0].length == 0) {
            return 0;
        }

        int m = costs.length;
        int n = costs[0].length;
        int[][] dp = new int[m][n];
        
        // Cost array for first house, find minimum from this
        dp[0] = costs[0];

        for(int i = 1; i < costs.length; i++) {
            dp[i] = new int[] {
                // Choose red + minimum cost so far with blue and green.
                costs[i][0] + Math.min(dp[i-1][1], dp[i-1][2]),

                // Choose blue + minimum cost so far with red and green
                costs[i][1] + Math.min(dp[i-1][0], dp[i-1][2]),

                // Choose green + minimum cost so far with blue and green
                costs[i][2] + Math.min(dp[i-1][0], dp[i-1][1])
            };
        }

        // Find minimum from the last
        return Math.min(Math.min(dp[m-1][0], dp[m-1][1]), dp[m-1][2]);
    }
}