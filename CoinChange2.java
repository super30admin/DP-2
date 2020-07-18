/*
Author: Akhilesh Borgaonkar
Problem: LC 518. Coin Change 2 (DP-2)
Approach: Using Dynamic Programming approach here to find the pattern of repeating sub-problems. 
Time Complexity: O(m*n) where m is number of coins and n is amount
Space complexity: O(m*n) constant
LC verified
*/

class Solution {
    public int change(int amount, int[] coins) {
        
        if(coins.length<1){
            if(amount==0)
                return 1;
            else
                return 0;
        }
        
        int r = coins.length+1;
        int c = amount+1;
        int[][] dp = new int[r][c];
        
        for(int j=0; j<c; j++)
            dp[0][j]=0;
        
        for(int i=1; i<r; i++)
            dp[i][0]=1;
        
        for(int i=1; i<r; i++){
            for(int j=1; j<c; j++){
                if(j < coins[i-1])
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
            }
        }
        
        return dp[r-1][c-1];
    }
}