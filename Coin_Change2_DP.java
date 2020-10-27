//Time Complexity : O(n^2)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : 


class Coin_Change2_DP {
    public int change(int amount, int[] coins) {
    	if(coins == null)
    		return 0;
    	
    	int[][] dp = new int[coins.length + 1][amount + 1];
    	
    	for(int k = 0; k < dp.length; k++)
    		dp[k][0] = 1;
    	
    	for(int i = 1; i < dp.length; i++)
    	{
    		for(int j = 1; j < dp[0].length; j++)
    		{
    			if(j < coins[i-1])
    				dp[i][j] = dp[i-1][j];
    			else
    				dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
    		}
    	}
    	return dp[dp.length - 1][dp[0].length - 1];
    }
    public static void main(String[] args)
    {
    	int[] coins = {1,2,5};
    	Coin_Change2_DP coinChange2DP = new Coin_Change2_DP();
    	System.out.println(coinChange2DP.change(20, coins));
    	
    }    

}
