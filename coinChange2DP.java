//above value + go back coin denomination times 
//until the value of the amount < denomination of coins get the above value only
class Solution {
    public int change(int amount, int[] coins) {
        //null
        if(coins == null) return 0;
        int m = coins.length; int n = amount;
        int [][] dp = new int[m+1][n+1];
        dp[0][0] = 1;
        for(int i=1; i<=m; i++){
            for(int j=0;j<=n;j++)
            {
                //denom of coin > amount
                if(j < coins[i-1])
                {
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[m][n];
    }
}