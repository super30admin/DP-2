// Time Complexity : o(S*n), where S is the amount
// Space Complexity :O(S), where s is the amount
// Did this code successfully run on Leetcode : Yes
//Approach: Problem is solved using dynamic programming approach.

class CoinChange2 {
    public int change(int amount, int[] coins) {
        int [][] dp = new int[coins.length+1][amount+1];
        
        int m = dp.length;
        int n = dp[0].length;
        
        dp[0][0] = 1;
        
        for (int i=1; i<m; i++) {
            dp[i][0] = 1;
            for (int j=1; j<n; j++) {
                if (j < coins[i-1]) {
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }    
        }
        return dp[m-1][n-1];
    }
}