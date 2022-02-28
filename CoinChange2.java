// Time Complexity : O(n) where n is #coins * amount
// Space Complexity : O(n) where n is length of coins * amount
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int change(int amount, int[] coins) {
        
        int n = coins.length;
        
        int[][] dp = new int[n+1][amount+1];
        
        // initializing
        for (int i = 0; i < n+1; i++) {
            dp[i][0] = 1;
        }
        
        for (int j = 1; j < amount+1; j++) {
            dp[0][j] = 0;
        }
        
        for (int i = 1; i < n+1; i++) {
            for (int j = 0; j < amount+1; j++) {
                if (coins[i-1] <= j) {
                    dp[i][j] = dp[i][j-coins[i-1]] + dp[i-1][j];
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][amount];
    }
}