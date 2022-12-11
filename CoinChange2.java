class CoinChange2 {
    public int change(int amount, int[] coins) {
    
    // null
    if (coins == null ) return 0;
    int n = amount;
    int m = coins.length;

    int[][] dp = new int[m+1][n+1];
    dp[0][0] = 1;

    for(int i = 1; i<=m;i++){
        dp[i][0] = 1;
    }     

    for (int i=1; i<=m; i++){
        for (int j=1; j<=n; j++){
            if(j < coins[i-1]){
                dp[i][j] = dp[i-1][j];
            } else {
                dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
            }
        }
    }
    return dp[m][n];

    //Recusrive approach
    //return helper(coins, amount,0);
    }

    /*private int helper(int[] coins, int amount, int idx){
        // base
        if (amount == 0) return 1;
        if (amount < 0 || idx == coins.length) return 0;
        //logic
        // dont choose
        int case1 = helper(coins, amount, idx+1);
        //choose
        int case2 = helper(coins, amount-coins[idx], idx);
        return case1+case2;
    }*/
}

