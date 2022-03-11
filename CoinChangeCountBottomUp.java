/**
 * Time complexity is O(n*k)
 * space complexity is O(n*k)
 */
class Solution {
    public int change(int amount, int[] coins) {
        Integer dp[][] = new Integer[coins.length+1][amount+1];
        
        for(int i = 0; i <= amount; i++) {
            dp[0][i] = 0;
        }
        for(int i = 0; i <= coins.length; i++) {
            dp[i][0] = 1;
        }
        
        for(int i = 0; i < coins.length; i++) {
            for(int j = 1; j <= amount; j++) {
                if(j >= coins[i] && dp[i+1][j-coins[i]] != Integer.MAX_VALUE) {
                    dp[i+1][j] = dp[i][j] + dp[i+1][j-coins[i]];
                }
                else {
                    dp[i+1][j] = dp[i][j];
                }
            }
        }
        
        return dp[coins.length][amount];   
    }
}