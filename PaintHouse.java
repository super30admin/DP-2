class Solution {
    // Time Complexity : O(n), where n is no of rows of cost 2d array.
    // Space Complexity : O(n)
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No

    public int paintHouse(int[][] cost) {
        return paintHouseHelper(cost);
    }

    public int paintHouse(int[][] cost) {
        int[][] dp = new int[cost.length][3];

        dp[0][0] = cost[0][0];
        dp[0][1] = cost[0][1];
        dp[0][2] = cost[0][2];
        for(int i = 0; i < dp.length; i++) {

            dp[i][0] = cost[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
            dp[i][1] = cost[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
            dp[i][2] = cost[i][2] + Math.min(dp[i-1][1], dp[i-1][0]);

        }

        return Math.min(dp[cost.length-1][0], Math.min(dp[cost.length-1][1], dp[cost.length-1][2]));
    }
}