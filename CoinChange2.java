// Time Complexity : o(m*n)
// Space Complexity :o(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class Solution {
    public int change(int amount, int[] coins) {
        if(coins.length==0)
            return 0;
          int[][] dp = new int[coins.length+1][amount+1];

          for(int i=0;i<dp.length;i++) // filling base cases
          {
              dp[i][0]=1;
          }
          for(int j=0;j<dp[0].length;j++) // filling base cases
          {
              dp[0][j]=0;
          }
          for(int i=1;i<dp.length;i++)
          {
              for(int j=1;j<dp[0].length;j++)
              {
                  if (coins[i-1] > j) //if denomination greater than curr amount
                      dp[i][j]=dp[i-1][j];
                  else
                      dp[i][j]=dp[i-1][j] + dp[i][j- coins[i-1]]; // total ways if we dont choose coin plus if we choose coin
                   
              }
          }       
          return dp[dp.length-1][dp[0].length-1];
  }
  } 
