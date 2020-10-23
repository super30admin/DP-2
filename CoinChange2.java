/**
 * TC : O(mn) SC: O(mn)
 * Approach : To get the number of ways to give change for any given amount, Explore all the values till the given amount.
 *            Store the result for the each value with given denomination and add them when encounter new way.
 */
class Solution {
    public int change(int amount, int[] coins) {
        if(coins == null) return 0;
        int[][] dp = new int[coins.length+1][amount+1];
        for(int i = 0; i < coins.length +1; i++){
            dp[i][0] = 1;
        }
        for(int i = 1; i < coins.length + 1; i++){
            for(int j = 1; j < amount +1; j++){
                if(j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
                }
            }
        }
        return dp[coins.length][amount];
    }
}