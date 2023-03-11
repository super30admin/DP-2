// Time Complexity : O(mn);  m = coins.lenth, n = amount
// Space Complexity : 0(mn); m = coins.lenth, n = amount
// Did this code successfully run on Leetcode : Yes
class Solution {
    public int change(int amount, int[] coins) {
        if(coins == null || coins.length == 0) {
            return 0;
        }

        int[][] dp = new int[coins.length + 1][amount + 1];
        // No way we can make amount 0 with no coins
        dp[0][0] = 0;
        
        // No. of ways to make amount 0 using any given coin is 1
        for(int i = 1; i <= coins.length; i++) {
            dp[i][0] = 1;
        }
        
        for(int i = 1; i <= coins.length; i++) {
            for(int j = 1; j <= amount; j++) {
                // If amount >= denomination
                if(j >= coins[i-1]) {
                    // No. of ways you can make amount - denom using the same coin + 
                    // No. of ways you can make amount without using the coin
                    dp[i][j] = dp[i][j - coins[i-1]] + dp[i-1][j]; 
                } else {
                    // No. of ways you can make amount without using the coin
                    // since we cannot use the coin because amount < denom
                    dp[i][j] = dp[i-1][j]; 
                }
            }
        }

        return dp[coins.length][amount];
    }
}