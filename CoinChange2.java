class CoinChange2 {
    public int change(int amount, int[] coins) {
        if(coins == null || coins.length == 0) return 0;
        //int m = coins.length;
        //int n = amount + 1;
        int [][] dp = new int[coins.length + 1][amount + 1];
        
        //first col
        for(int i = 0; i < dp.length; i++){
            dp[i][0] = 1; 
        }
        
        //first row
        for(int i = 1; i < dp[0].length; i++){
            dp[0][i] = 0;
        }
        
        //filling rest of the elements in the matrix 
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(coins[i - 1] > j){ //when denomination of coin > than amount
                    dp[i][j] = dp [i - 1][j];
                }else{
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i-1]];
                }    
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
