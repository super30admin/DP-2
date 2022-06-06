// Time Complexity : O(m*n)
// Space Complexity : O(n) where the length of coins array
// Did this code successfully run on Leetcode : yes


class coinChange{
    public int change(int amount, int[] coins) {
        if(coins == null || coins.length == 0) return 0;
        int m = coins.length, n = amount;
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 1;
        for(int i=1; i<m; i++){
            for(int j=0; j<n+1;j++){
                if(j < coins[i-1]){
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