// Time Complexity : O(m * n)
// Space Complexity : O(m * n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*
Here we have to decide no. of possible ways for any amount using coins

So , we will add both the no. of ways for every curr amount value
means ways of selecting the coin and not selecting the coin everytime.
*/


class Solution {
    public int change(int amount, int[] coins) {
        
        if(coins == null) return 0;
        int m = coins.length;
        int n = amount;
        
        int[][] dp = new int[m+1][n+1];
        
        //For using coins, we want to make chaneg for amount = 0  => 1 way
        for(int i = 0; i < dp.length; i++){
            dp[i][0] = 1;
        }
        
        //By defaullt, it will having value 0.
        // for(int j = 1; j < dp[0].length; j++){
        //     dp[0][j] = 0;
        // }
        
         
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                
                //Only 1 case 
                if(j < coins[i-1]){ // If denomination is less than amount or j
                    dp[i][j] = dp[i-1][j];
                }
                //2 cases -> Left + Right
                else{
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]] ;
                }
            }
        }
        
        int result = dp[dp.length - 1][dp[0].length - 1];
        
        return result;
        
    }
   
}

