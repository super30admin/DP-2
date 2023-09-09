// Time Complexity : O(n * k) where n is length of coins and k is amount
// Space Complexity : O(n * k) we store dp array of size n * k
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, coming up with dp[i][j] equation did not come right away

public class Problem2 {
    public int change(int amount, int[] coins) {
        if(coins.length == 0 || coins == null) return 0;

        int[][] dp = new int[coins.length+1][amount+1];
        for(int i = 0; i < coins.length + 1; i++){
            dp[i][0] = 1;
        }

        for(int i = 1; i < coins.length+1; i++){
            for(int j = 1; j < amount+1; j++){
                if(j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = dp[i -1][j] + dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[coins.length][amount];
    }
}
