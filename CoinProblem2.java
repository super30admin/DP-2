class Solution {
    public int change(int amount, int[] coins) {
        int m = coins.length,n=amount;
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 1;
        for(int i=1;i<amount+1;i++)
            dp[0][i] = 0;
        
        for(int i =1;i<m+1;i++){
            for(int j = 0;j<n+1;j++){
                if(j<coins[i-1])
                    dp[i][j]=dp[i-1][j];
                else
                    dp[i][j]=dp[i-1][j] + dp[i][j-coins[i-1]];
            }
        }
        return dp[m][n];
    }
}
