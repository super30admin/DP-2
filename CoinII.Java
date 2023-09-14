class CoinII {
    public int change(int amount, int[] coins) {
        int n = coins.length, m = amount;

        int[] dp = new int[m+1];
        if(coins == null || coins.length == 0)
           return 0;

        dp[0] = 1;

        for(int i = 1; i<= n; i++){
            for(int j = 0; j<= m; j++){
                if(j<coins[i-1]){
                    dp[j] = dp[j];
                }else{
                    dp[j] = dp[j] + dp[j-coins[i-1]];
                }
            }
        }
        return dp[m];
    }
