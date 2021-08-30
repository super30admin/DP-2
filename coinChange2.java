// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : yes
class coinChange2{
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        if(coins == null || coins.length == 0) return 0;
        for(int i=0; i<dp.length; i++){
            dp[i][0] = 1;
        }
        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                //amount is lesser than denomination of the coin
                if(j < coins[i - 1]){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}