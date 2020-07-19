// Time Complexity : O(amount * n) where n=coins length
// Space Complexity : O(amount * n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : DP solutions are tough to come up with


// Your code here along with comments explaining your approach

class Solution {
    int result,target;
    public int change(int amount, int[] coins) {
        if(coins==null || coins.length==0 && amount!=0)
            return 0;
        else if( coins.length==0 && amount==0)
            return 1;
        
        if(coins.length==1)
        {
            if(amount%coins[0]==0)
                return 1;
            else
                return 0;
        }   
     
        int[][] dp=new int[coins.length+1][amount+1];
        
        for(int i=0;i<coins.length+1;i++)
        {
            dp[i][0]=1;
            
            for(int j=1;j<amount+1;j++)
            {
                if(i==0)
                    dp[i][j]=0;
                else if(j<coins[i-1])
                    dp[i][j]=dp[i-1][j];
                else
                {
                    int index=j-coins[i-1];
                    dp[i][j]=dp[i-1][j]+dp[i][index];
                }
            }
        }
        
        return dp[coins.length][amount];
    }
} 