class Solution {
    public int change(int amount, int[] coins) {
        // check for coins array to be null or empty
        if(coins == null || coins.length == 0) return 0;
        int[][] dp = new int[coins.length + 1][amount + 1];
        // fill the first column of dp matrix with 1
        for(int i = 0; i < dp.length; i++){
            dp[i][0] = 1;
        }
        for(int i = 1; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                // until amount is less than denomination, choose the element from previous row
                if(j < coins[i - 1]){
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // else the previous row element + element in the same row, demonination col to the left
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }
        // the last element of the dp matrix is the result
        return dp[dp.length - 1][dp[0].length - 1];
    }
}