//Time complexity=O(N*M), M=amount, N=no. of coins
//Space complexity=O(N,M), M=amount, N=no. of coins
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No 

//We are creating an matrix of the coins and the amount, to obtain the all possible combination we are taking all the possible way to create the numbers upto the given amount. So if the amount is greater than coin then we are just using the previous value ,, otherwise for a amount we are taking the previous combination + the combination required for the amount(i.e. current amount - current coin) of the current coin. 
class Solution {
    public int change(int amount, int[] coins) {
        //base case
        if(coins.length==0 && amount==0)
            return 1;
		int[][] dp= new int[coins.length+1][amount+1];
        for(int i=0;i<=amount;i++)
        {
            dp[0][i]=0;
        }
        for(int i=1;i<=coins.length;i++)
        {
            dp[i][0]=1;
        }
        
        for(int i=1;i<dp.length;i++)
        {
            for(int j=1;j<dp[0].length;j++)
            {
                if(j < coins[i-1])
                    dp[i][j]=dp[i-1][j];
                else
                {
                    dp[i][j]=dp[i][j-coins[i-1]]+dp[i-1][j];
                }
            }
        }
       return dp[coins.length][amount];
	        
    }
}