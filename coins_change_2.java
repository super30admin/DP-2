//SC: O(n*n)
//TC: O(n*n)
class Solution {
    
    public int change(int amount, int[] coins) {
     int row=coins.length+1;
     int col=amount+1;
     int[][] dp=new int[row][col];
     dp[0][0]=1;
     for(int i=1;i<col;i++)
     dp[0][i]=0;
     for(int i=1;i<row;i++)
     {
         for(int j=0;j<col;j++)
         {
             if(j<coins[i-1])
             dp[i][j]=dp[i-1][j];
             else
             {
                 dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]];
             }
         }
     }
        return dp[row-1][col-1];
    }
}//SC: O(n*n)
//TC: O(n*n)
class Solution {
    
    public int change(int amount, int[] coins) {
     int row=coins.length+1;
     int col=amount+1;
     int[][] dp=new int[row][col];
     dp[0][0]=1;
     for(int i=1;i<col;i++)
     dp[0][i]=0;
     for(int i=1;i<row;i++)
     {
         for(int j=0;j<col;j++)
         {
             if(j<coins[i-1])
             dp[i][j]=dp[i-1][j];
             else
             {
                 dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]];
             }
         }
     }
        return dp[row-1][col-1];
    }
}