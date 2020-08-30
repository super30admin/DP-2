// Time Complexity : O(n*m) n refers to the number of denominations, m refers to the amount
// Space Complexity : O(n*m) n refers to the number of denominations, m refers to the amount
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No



class CoinChange2
{
    public int change(int amount, int[] coins) 
    {
        int[][] dp=new int[coins.length+1][amount+1];
        
	    for(int i=0;i<=coins.length;i++)
        {
	    dp[i][0]=1;//If the amount is 0, empty array is the only way
        }
        for(int j=1;j<=amount;j++)
        {
            dp[0][j]=0; //O denomination has no ways to sum up to any amount
        }
        for(int i=1;i<=coins.length;i++)
        {
            for(int j=1;j<=amount;j++)
            {
                if(coins[i-1]>j) //Checking if the denomination is greater than the amount
                    dp[i][j]=dp[i-1][j]; //The previous denomination's number of ways for this amount is considered
                else
                    dp[i][j]=dp[i][j-coins[i-1]]+dp[i-1][j]; //The current coin is chosen[Amount-current coin] and the previous denomination's number of ways
            }
            
        }
	
     return dp[coins.length][amount];   
    }  
}