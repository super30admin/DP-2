// Time Complexity : O(m*n)
// Space Complexity : O((m+1)*(n+1))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this: Had to completely rely on lecture. Still not confident.
// Summary: create 2D array and keep adding from previous entry


class Solution {
    public int change(int amount, int[] coins) {
        if(coins == null) return 0;
        int[][] dp = new int[coins.length + 1][amount + 1];
        dp[0][0] = 1; //row 0, column 0
        
        for(int i = 0; i < dp.length; i++){
            dp[i][0] = 1;
        }        
        
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(j < coins[i-1]){
                    dp[i][j] = dp[i-1][j]; //if amount is less than denominator, get value from top row
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }
    
        return dp[dp.length - 1][dp[0].length - 1];
        
    }
    
}

