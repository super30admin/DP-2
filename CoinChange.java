// Time Complexity : O(n*m), n is number of coins and m is amount.
// Space Complexity : O(m), m is the amount.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public int change(int amount, int[] coins) {
       if (coins.length == 0 && amount != 0) return 0;
        if (amount == 0) return 1;
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (j >= coins[i-1]) { // if amount >= denomination
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];    
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        } 
        return dp[coins.length][amount];
    }
      
}