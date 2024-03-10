// Time Complexity : O(nm) where n is number of coins and m is the amount
// Space Complexity : O(nm) where n is number of coins and m is the amount. We can optimize this using a 1d array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/* Approach:
We use DP here. We create a 2d array to store previous occurances of subproblema and use it to optimize the 
current problem. 
Case 0: where amount < denomination, we update it to the value from index in upper row (if we do not choose the coin)
Case 1: where we add prev row's val to the val at (current row - denomination) 
finally we have considered all combinations, hence return dp[n][m]
*/ 
class CoinChangeII {
    public int change(int amount, int[] coins) {
     int m = amount;
     int n = coins.length;   
     int [][] dp = new int[n+1][m+1];
     dp[0][0] = 1;

     for (int i=1;i<dp.length;i++){
         for (int j = 0; j < dp[0].length; j++){
             //if amount < denomination
             if( j < coins[i-1] ){
                 dp[i][j] = dp[i-1][j];
             }
             else{
                 dp[i][j] = dp[i-1][j] + dp[i][j - coins[ i - 1]];
             }
         }
     }
     return dp[n][m];
    }
}