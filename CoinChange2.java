
class CoinChange2 {
    public int change(int amount, int[] coins) {
        if(coins == null || coins.length == 0){
            return 0;
        }
        
        int m = coins.length;
        int n = amount;
        
        int[][] dp = new int[m+1][n+1]; //+1 to accomodate 0/0 rows/col
        
        //with any coins to form amount 0, only combination is not to choose the coins
        //Hence put 1 into column 0
        for(int i = 0; i <= m; i++){
            dp[i][0] = 1;
        }
        
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                
                //amount is less than denomination of coin then put case0 value
                //=> copy just above
                if(j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }
               //sum combinations from case-0 and case-1 
                else{
                   dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]; 
                }
            }
        }
        
        return dp[m][n];
    }
}