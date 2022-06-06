public class CoinChange {
    //TC is O(mn) where m is rows and n is the amount
    // SC is O(mn) as new matrix is used
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];
        // if(amount == 0 || coins.length == 0) return 0;
        dp[0][0] = 1;
        for(int i =1; i< dp.length; i++){
            for(int j=0; j<dp[0].length;j++){
                if(j<coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else
                    dp[i][j] = dp[i-1][j]+dp[i][j-coins[i-1]];
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}