
Problem-518 (coin change 2)
// Time Complexity :O(mn)
// Space Complexity :O(mn)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


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








Problem-256 (Paint-house)
// Time Complexity :O(mn)
// Space Complexity :O(mn)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
  
  class Solution {
    public int minCost(int[][] costs) {
        int n=costs.length;
        int min=Integer.MAX_VALUE;
        for(int i=n-2; i>=0;i--)
        {
            costs[i][0]= costs[i][0]+ Math.min(costs[i+1][1], costs[i+1][2]);
            costs[i][1]= costs[i][1]+ Math.min(costs[i+1][0], costs[i+1][2]);
            costs[i][2]= costs[i][2]+ Math.min(costs[i+1][0], costs[i+1][1]);
        }
        for(int i=0; i<=2;i++)
        {
            min= Math.min(costs[0][i], min);
        }
        return min;
    }
}
