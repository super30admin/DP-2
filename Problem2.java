// ## Problem2 (https://leetcode.com/problems/coin-change-2/)
// time: O(m*n)
// space O(m*n)
class Solution {
    public int change(int amount, int[] coins) {
    // time: O(2^n) we are splitting in 2 parts that why this is the power of 2
        // null case
        if (coins == null || coins.length == 0) return 0;
        
        int m = coins.length;
        int n = amount;
        int [][] dp = new int[m+1][n+1];
        dp[0][0] = 1;
        
       for (int i = 1; i<=m; i++) {
           for (int j = 0; j <=n; j++) {
                 if(j < coins[i-1]) {
                    dp[i][j] = dp[i-1][j];
                 } else {
                     dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                 }
            }
        }
        return dp[m][n];
    }
}