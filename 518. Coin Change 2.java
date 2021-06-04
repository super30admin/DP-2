class Solution {
    public int change(int amount, int[] coins) {
        if(coins == null)
            return 0;
        // here we use 2-D array to optimize the solution, dynamic programming
        int[][] dp = new int [coins.length + 1][amount + 1];
        dp[0][0] = 1;
        // we should set the first column which indicates the amount == 0 as 1;
        for(int i = 0; i < dp.length; i++){
            dp[i][0] = 1;
        }
        // contruct the matrix to memorize the repeated values to reduce the complexity
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(j < coins[i - 1]){
                    dp[i][j] = dp[i - 1][j];
                }else{
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }
        return dp[coins.length][amount];
    }
}