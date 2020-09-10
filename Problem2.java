Time Complexity: O(mn). m is number of coins and n is amount.
Space Complexity: O(mn). DP array
Ran successfully on leetcode: yes.

class Solution {
    public int change(int amount, int[] coins) {
        
        int length = coins.length;
        int[][] dp = new int[length + 1][amount + 1];
        
        dp[0][0] = 1;
        
        for(int i = 1; i <= length; i++){
            for(int j = 0; j <= amount; j++){
                if(j < coins[i - 1]){
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }
        
        return dp[length][amount];
    }
}
