// Time Complexity : O(m*n) m is the coins and n is the amount
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

public class CoinChange2 {
    public int change(int amount, int[] coins) {
        //null check
        if(coins == null || coins.length ==0) return 0;

        int m = coins.length;
        int n = amount;

        int dp[][] = new int[m+1][n+1];
        dp[0][0] = 1;

        for(int i=1; i<=m; i++){
            for(int j=0; j<=n; j++){
                if(j<coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }

        return dp[m][n];
    }
}