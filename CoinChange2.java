// Time Complexity : O((amount+1)*(coins.length+1))
// Space Complexity : O((amount+1)*(coins.length+1))
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :
class Solution {
    public int change(int amount, int[] coins) {
        if(coins == null || coins.length == 0) return 0;

        int[][] dp = new int[coins.length+1][amount+1];
        for (int i=0; i< coins.length+1; i++) {
            dp[i][0] = 1;
        }
        for (int i=1; i<coins.length+1; i++) {
            for (int j=1; j<amount+1; j++) {
                // if target amount is less than denomination
                if (j < coins[i-1]) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }

        return dp[coins.length][amount];

    }

}