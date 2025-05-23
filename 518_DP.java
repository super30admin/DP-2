// TC -- O(M*N)
// SC -- O(M*N)

// Space can be reduced further to 1D array.which will be O(N)

class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length+1;
        int m = amount+1;
        int [][] dp = new int[n][m];
        dp[0][0] = 1;
        for(int i = 1; i<n; ++i){
            for(int j=0; j<m; ++j){
                if( coins[i-1] > j)
                    dp[i][j]  = dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
            }
        }
        return dp[n-1][m-1];
    }
}
