// Time Complexity :  O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    /* Recursive Approach
    public int change(int amount, int[] coins) {
        
        if(coins.length==0 || coins==null)
            return 0;
        
        return helper(coins,amount,0);
    }
    
    private int helper(int[] coins,int amount,int index)
    {
        if(amount==0)
            return 1;
        if(amount<0 || index==coins.length)
            return 0;
        
        int case1=helper(coins,amount,index+1);
        int case2=helper(coins,amount-coins[index],index);
        
        return case1+case2;
    } */
	// DP Approach
    public int change(int amount, int[] coins) {
        if(coins.length==0 || coins==null)
            return 0;
        
        int[][] dp=new int[coins.length+1][amount+1];
        
        for(int i=0;i<=coins.length;i++)
            dp[i][0]=1;
        
        for(int i=1;i<=coins.length;i++)
        {
            for(int j=1;j<=amount;j++)
            {
                //amount denomination
                if(j<coins[i-1])
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
