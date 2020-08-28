
// Time Complexity : O(N2)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/*
    At each iteration, we store the no of ways we can get that denomination using previous coins +
    no. of ways we can get (denomination - current coin). The result is stored at the end i.e last element of array
    is the total no of ways we can get the target denomination.

*/

class Solution {
    public int change(int amount, int[] coins) {
         int[][] dp = new int [coins.length+1][amount+1];
        for(int j=1; j<=amount;j++){
            dp[0][j] = 0;
        }
        for(int j=0; j<=coins.length;j++){
            dp[j][0] = 1;
        }
        
        for(int i=1; i<=coins.length; i++){
            for(int j=1; j<=amount; j++){
                if(j < coins[i-1]) 
                    dp[i][j]= dp[i-1][j];
                else{
                    dp[i][j]= dp[i][j-coins[i-1]] + dp[i-1][j];
                }
                
        }
        
    }
        return dp[coins.length][amount] ;
    }
}