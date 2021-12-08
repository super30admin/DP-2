/*
Space is O(n) where n is number of houses
Time is also O(n)
Here we are going with bottom up approach where we are taking a red color and then seeing alternate color for below its and navigate till top and later just take min from top row
*/
class Solution {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0) {
            return 0;
        }

        int dp[][] = new int[costs.length][3];

        for (int i = 0; i < 3; i++) {
            dp[costs.length - 1][i] = costs[costs.length - 1][i];
        }

        for(int i = costs.length - 2; i >= 0; i--){
            dp[i][0] = costs[i][0] + Math.min(dp[i + 1][1], dp[i + 1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i + 1][2], dp[i + 1][0]);
            dp[i][2] = costs[i][2] + Math.min(dp[i + 1][0], dp[i + 1][1]);
        }

        return Math.min(dp[0][1], Math.min(dp[0][2], dp[0][0]));
    }
}