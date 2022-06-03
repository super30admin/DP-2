//Mention the following in your submissions:
// Time Complexity : O(mn) where m and n are the amount and no of coins
// Space Complexity : O(mn) as we are creating a new mn array
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes



class Solution {
    public int change(int amount, int[] coins) {
        int [][]dp = new int[coins.length+1][amount+1];
        for(int i =0;i<coins.length+1;i++)
            dp[i][0]=1;
        
        for(int i =1;i<amount+1;i++ )
            dp[0][i]=0;
        
        for(int i=1;i<dp.length;i++)
        {  for(int j=1;j<dp[0].length;j++)
            {  dp[i][j]+= dp[i-1][j];
                if(coins[i-1]<=j)
                    dp[i][j]+=dp[i][j-coins[i-1]];
        
             }
                
        }
        return dp[coins.length][amount];
        
     
    }
}