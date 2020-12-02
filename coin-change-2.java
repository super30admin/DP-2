// Time - O(MN)
// Space - O(MN)

class Solution {
    public int change(int amount, int[] coins) {
        
        if(coins == null) {
            return 0;
        }
        if(coins.length == 0 && amount == 0) {
            return 1;
        }
        if(coins.length == 0 && amount > 0) {
            return 0;
        }
        int[][] dp = new int[coins.length+1][amount+1];
        
        for(int i=0;i<dp.length;i++) {
            dp[i][0] = 1;
        }
        
        for(int i=1;i<dp.length;i++) {
            for(int j=1;j<dp[0].length;j++) {
                if(coins[i-1] <= j) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        return dp[coins.length][amount];
        
    }
}
