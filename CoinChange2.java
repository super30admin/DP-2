class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];
        
        //dp[i][j] number of ways to make amount j using ith coin
        for(int i=0;i<=coins.length;i++){
            dp[i][0] = 1;
        }
        for(int i=1;i<=coins.length;i++){
            for(int j=1;j<=amount;j++){
                if(coins[i-1]>j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = dp[i][j-coins[i-1]] + dp[i-1][j];
                }
            }
        }
        return dp[coins.length][amount];
    }
}