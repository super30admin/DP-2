// Time Complexity : o(mx n)
// Space Complexity :o(mxn)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

class Solution {
  public int minFallingPathSum(int[][] A) {
      int n=A.length;
      int dp[][] = new int[n][n];
      for(int i=0;i<n;i++){
          dp[0][i]=A[0][i];
      }
      for(int i=1;i<n;i++)
      {
          for(int j=0;j<n;j++){
              if(j==0) dp[i][j]=A[i][j]+Math.min(dp[i-1][j],dp[i-1][j+1]);
              else if(j==n-1) dp[i][j]=A[i][j]+Math.min(dp[i-1][j],dp[i-1][j-1]);
              else dp[i][j]=A[i][j]+Math.min(dp[i-1][j],Math.min(dp[i-1][j+1],dp[i-1][j-1])); 
  }
}
      int min=Integer.MAX_VALUE; 
      for(int i=0;i<n;i++){
          if(min>dp[n-1][i]) min=dp[n-1][i];
      }
      return min;
}
}