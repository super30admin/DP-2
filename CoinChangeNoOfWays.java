// Time Complexity : O(mn) // n is total number of denomination coins, m is total
// Space Complexity : O(mxn) // m total amount with , n total number of denomination
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Learning DP. Able to solve after watching class recording twice. Needs help.

/*
    We are starting building bottom up tree by making new matrix.
    Calculate ways at each level. Go to all the way up. At end, all the ways sum up in last cell of matrix.

    It is good Dynamic program pattern to learn.
*/

//Using Matrix
public class CoinChangeNoOfWays {
       public int change(int amount, int[] coins) {
           if(coins == null || coins.length == 0 )
               return 0;

           int n = coins.length;
           int m = amount;
           int[][] dp = new int[n+1][m+1];
           dp[0][0] = 1;

           for(int j = 1; j<=m; j++){
                dp[0][j] = 0;
           }

           for(int i =1; i<=n; i++){
               for(int j=0; j<=m; j++){
                   if(j<coins[i-1]){
                       dp[i][j] = dp[i-1][j];
                   }else{
                       dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                   }
               }
           }
           return dp[n][m];
        }
}