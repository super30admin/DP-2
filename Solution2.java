// Time complexity: O(N*M), where N is the length of coins array and M is the amount. 
// Space complexity: O(N*M). 

class Solution2 {
    public int change(int amount, int[] coins) {
        int dp[][] = new int[coins.length+1][amount+1]; 
        
        for(int i=0; i<=coins.length; i++) {
            dp[i][0] = 1;
        }
        
        for(int i=1; i<=coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                // if coin is less than amount
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                }
                // else add ways by choosing and not choosing the coin
                else {
                     dp[i][j] = dp[i][j-coins[i-1]] + dp[i-1][j]; 
                } 
            }
        }
        
        return dp[coins.length][amount]; 
    }
}
