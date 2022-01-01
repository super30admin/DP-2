//Time complexity: O(m*n)
//Space complexity: O(m*n)

class Solution {
    public int change(int amount, int[] coins) {
         int dp[][]=new int[coins.length+1][amount+1];
        dp[0][0]=1;
        int n=dp.length;
        int m=dp[0].length;
        
            for(int i=0;i<n;i++)
            {
                dp[i][0]=1;
            }
        
       for(int i=1;i<n;i++)
       {
           for(int j=1;j<m;j++)
           {
               if(j>=coins[i-1])
               {
                   dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]];
               }
               else
               {
                   dp[i][j]=dp[i-1][j];
               }
           }
       }
        return dp[n-1][m-1];
    }
}