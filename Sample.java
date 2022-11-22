
Problem-518 (coin change 2)
// Time Complexity :O(mn)
// Space Complexity :O(mn)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :Yes


// Your code here along with comments explaining your approach
  
  class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp= new int[coins.length+1][amount+1];
        int n=coins.length+1;
        for(int i=0; i<n; i++)
        {
            dp[i][0]=1;
        }
        for(int i=1; i<=coins.length; i++)
        {
            for(int j=1; j<=amount; j++)
            {
                if(coins[i-1]>j)
                {
                    dp[i][j]=dp[i-1][j];
                }
                else
                {
                    dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[coins.length][amount];
    }
}
