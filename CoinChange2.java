class CoinChange2 {

    // Time Complexity: O(nw) (where n-> no. of coins and w -> amount)
    // Space Complexity: O(nw)
    
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];
        dp[0][0] = 1;
        
        for(int i = 1; i <= coins.length; i++){
            for(int j = 0; j <= amount; j++){
                if(j < coins[i-1])
                    dp[i][j] = dp[i-1][j];
                else{
                    int include = dp[i][j - coins[i-1]];
                    int exclude = dp[i-1][j];
                    dp[i][j] = include + exclude;
                }
            }
        }
        return dp[coins.length][amount];
    }
}