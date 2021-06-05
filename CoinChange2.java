class CoinChange2{
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];

        // fill dummy
        for(int i=0; i< dp.length; i++){
            dp[i][0] = 1;
        }

        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                if(j < coins[i-1])
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
            }
        }

        return dp[dp.length-1][dp[0].length-1];
    }


//    public int change(int amount, int[] coins) {
//        return helper(amount, coins, 0);
//    }
//
//    public int helper(int amount, int[] coins, int index){
//        // base
//        if(amount == 0) return 1;
//        if(amount < 0 || index >= coins.length) return 0;
//        // logic
//        // choose coin
//        int case1 = helper(amount - coins[index], coins, index );
//        // not choose coin
//        int case2 = helper(amount, coins, index+1 );
//        return case1+ case2;
//    }
}