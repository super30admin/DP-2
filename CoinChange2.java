// TC - O (m*n)
// SC - O (m*n)
class CoinChange2 {
    public int change(int amount, int[] coins) {
        if(coins == null) return 0;
        int n = coins.length; int m = amount;
        int[][] dp = new int[n+1][m+1];
        dp[0][0] = 1;
        for(int i = 1; i <= n; i++) {
            for(int j = 0; j <= m; j++) {
                // if denom > amount
                if(j < coins[i-1]) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
                }
            }
        }
        return dp[n][m];
    }
}