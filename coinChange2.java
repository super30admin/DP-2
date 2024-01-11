// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

class Solution {
    public void helper(int amount, int[] coins, int[][] dp) {
        int m = coins.length;
        int n = amount;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }

    }

    public int change(int amount, int[] coins) {
        int m = coins.length;
        int n = amount;
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            dp[0][i] = 0;
        }
        helper(amount, coins, dp);
        return dp[m][n];
    }
}

/*
 * Recursive solution gives TLE
 * 
 * class Solution {
 * 
 * public int helper(int amount,int[] coins, int idx) {
 * if(idx == coins.length || amount <= 0) {
 * if(amount == 0) return 1;
 * return 0;
 * }
 * 
 * int left = helper(amount,coins,idx+1);
 * int right = helper(amount - coins[idx],coins,idx);
 * 
 * return left+right;
 * }
 * 
 * 
 * public int change(int amount, int[] coins) {
 * return helper(amount,coins,0);
 * }
 * }
 */
