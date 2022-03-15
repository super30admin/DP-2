class Solution {
    public int change(int amount, int[] coins) {
        
        int n = amount;
        int m = coins.length;
        
        int dp[][] = new int[m+1][n+1];
        
        for(int i=0;i<dp.length;i++)
        {
            dp[i][0] = 1;
        }
        
        for(int i=1;i<dp.length;i++)
        {
            for(int j=1;j<dp[i].length;j++)
            {
                if(coins[i-1] > j)
                {
                    dp[i][j] = dp[i-1][j];
                }
                else
                {
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }
        
        int result = dp[dp.length-1][dp[dp.length-1].length-1];
        
        return result;
    }
}