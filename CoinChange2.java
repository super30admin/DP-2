class Solution {

    /** Method 1
    TC -> O(mn), where m = no of coins, n = amount
    SC -> O(mn), To create the DP array
    */
    public int change(int amount, int[] coins) {
        if(coins == null || coins.length == 0) return 0;
        // a matrix of coins VS amount
        int m = coins.length, n = amount;
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 1;
        for(int i=1; i<=m; i++){
            for(int j=0; j<=n; j++){
                if(j < coins[i-1])
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
            }
        }
        return dp[m][n];
    }

    // Optimized DP
    /** Method 2
    TC -> O(mn), where m = no of coins, n = amount
    SC -> O(n), To create the 1D DP array, n = amount
    */
    public int optimizedChange(int amount, int[] coins){
        if(coins == null || coins.length == 0) return 0;
        //Here we take a 1D DP, manipulate in the same row
        int m = coins.length, n = amount;
        int dp[] = new int[n+1];
        dp[0] = 1;
        for( int i=1; i<=m; i++){
            for(int j=0; j<=n; j++){
                if(j >= coins[i-1])
                    dp[j] = dp[j] + dp[j - coins[i-1]];
            }
        }
        return dp[n];
    }
}
