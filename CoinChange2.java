/*

Thought Process: Visualize on white board why it is a DP problem. Then create 2D array visualization of coins vs amounts.

TC -> O(M * N) : where M = coins+1 and N = amount+1
SC -> O(M * N)

Difficulties faced -> Initial edge case. Solved this after solving Coin Change 1.
*/

class CoinChange2 {
    public int change(int amount, int[] coins) {
        
        if(coins == null || coins.length == 0) {
            if(amount == 0) return 1;
            else return 0;
        }
        
        int[][] dp = new int[coins.length+1][amount+1];
        
        for(int i=0; i<dp.length; i++){
            dp[i][0] = 1;
        }
        
        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                if(j - coins[i-1] < 0)
                    dp[i][j] = dp[i-1][j];
                else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}