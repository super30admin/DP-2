// Time Complexity : O(n*amount)
// Space Complexity :O(amount)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

class Solution {
    public int change(int amount, int[] coins) {
        
        int dp[][] = new int[coins.length+1][amount+1];
        
        for(int i = 0 ; i <= coins.length ; i++){
            dp[i][0] = 1;
        }
        
         for(int i = 1 ; i <= amount ; i++){
            dp[0][i] = 0;
        }
        
         for(int row = 1 ; row <= coins.length ; row++){
             for(int col = 1 ; col <= amount ; col++){
             
                 if(col < coins[row-1]){
                     dp[row][col] = dp[row-1][col];
                 }else{
                     dp[row][col] = dp[row-1][col] + dp[row][col - coins[row-1]];
                 }
            
         }        
    }
        
        return dp[coins.length][amount];
}
}
