// Time complexity: O(n*m) where n is the number of coins and m is the amount
// Space complexity: O(n*m) where n is the number of coins and m is the amount
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Uses a 2D DP table where dp[i][j] represents the number of ways to make amount `j` using the first `i` coins.  
 * If the current coin is greater than `j`, carry forward dp[i-1][j] (exclude the coin); otherwise, sum dp[i-1][j] and dp[i][j - coins[i-1]].  
 * Returns the total ways to make the given amount using the given coin denominations.
 */

class Solution {
    public int change(int amount, int[] coins) {

        int[][] dp = new int[coins.length+1][amount+1];

        for(int i = 0; i <= coins.length ; i++) {
            dp[i][0] = 1;
        }

        for(int j = 0 ; j < amount+1 ; j++) {
            dp[0][j] = 0;
        }
        
        for(int i = 1 ; i <= coins.length ; i++) {
            for(int j = 1; j <= amount ; j++) {
                if(j < coins[i-1]) {
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[coins.length][amount];
    }
}
