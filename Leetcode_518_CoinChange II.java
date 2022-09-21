// this is B-F , exhausted recursive approach
//TC and SC is exponential
// approach - choose, and statys at the same index , and deduce it from the amount and go on recursively
// if we dont choose, increase the index and amount stays the same. 
// at last we check , if the amount is zero, means we found combination and return 1, 
// if we find amount < 0; we reach to the end of the array that means we dint find any combination and so we return 0;


class Solution {
    public int change(int amount, int[] coins) {
		if(coins == null || coins.length ==0) return 0;
		
		return helper(coins, 0, amount);

	}
	
	private int helper(int[] coins, int index, int amount)
	{
		//base case
		//if we reach to the end of the array or the amount is less thn 0, means we did not find any combinations there and so return 0. 
		if(index == coins.length || amount < 0) retun 0;
		
		//if we reach to the amount ==0, that means we actually found a combination
		if(amount ==0) retun 1;
		
		// not choose
		int case1 = helper(coins, index+1, amount);
		
		//choose
		int case2 = helper(coins, index, amount-coins[index]);
		
		return case1+case2;
	}
}



// DP- Optimized Approach 
//length of the coins == m and amount =n
//TC - O(m*n)
//SC = O(m*n)
class Solution {
    public int change(int amount, int[] coins) {
		if(coins == null || coins.length ==0) return 0;
	
		int[][] dp = new int[coins.length+1][amount +1]; // to cover the base case with row zero and col 0
		
		for(int i= 0; i< coins.length+1; i++)
		{
			dp[i][0] = 1;
		}
		for(int i=1; i< coins.length +1; i++)
		{
			for(int j =1; j< amount+1; j++)
			{
				// if amount is less than the denomination
				if(j < coins[i-1]) // why coins[i-1] -- becuase coins have 1,2,5; but my matrix has 0,1,2,5
				{
					dp[i][j] = dp[i-1][j];
				}
				else
				{
					dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
				}
			}
		}
		return dp[coins.length][amount];
	}
}