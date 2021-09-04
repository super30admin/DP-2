// Time Complexity : O(nm)
// Space Complexity : O(nm)
// Did this code successfully run on Leetcode : Yes.
// Any problem you faced while coding this : None.

public class coinChange2 {
    public int change(int amount, int[] coins) {
        int len = coins.length;
        int [][] dp = new int[len+1][amount+1];
        dp[0][0] = 1;

        for(int i = 0; i < len+1; i++){
            dp[i][0] = 0;
        }

        for(int j = 0; j < len+1; j++){
            dp[0][j] = 0;
        }

        for(int i = 1; i < len+1; i++){
            for(int j = 1; j < amount+1; j++){
                if(coins[i-1] <= j){
                    dp[i][j] =  dp[i-1][j] + dp[i][j - coins[i-1]];
                }
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[len][amount];
    }
}
