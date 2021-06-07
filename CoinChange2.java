// Time Complexity : O(m+n)
// Space Complexity : O(m+n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int change(int amount, int[] coins) {
       //recursion version
      //null case
      if(coins.length == 0 || coins == null) return 0;
      int[][] dp = new int[coins.length+1][amount+1];
       dp[0][0] =1;
      
      //fisrt colum
      for(int i=0;i<dp.length;i++) {
        dp[i][0] = 1;
      }
      for(int i=1;i<dp.length;i++) {
        for(int j=1;j<dp[0].length;j++) {
          if(j < coins[i-1]) {
            //zero case
            dp[i][j] = dp[i-1][j];
          } else {
             //zero and one case
             dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
          }
        }
      }
      
      return dp[dp.length-1][dp[0].length-1];
      
    }
}