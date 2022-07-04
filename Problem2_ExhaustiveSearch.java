//Time Complexity : O(2^n)
//Space Complexity : O(n) : recursion stack
//Solution accepted on Leetcode, Time Limit Exceeded for submission since this is exhaustive search.

public class Problem2_ExhaustiveSearch {
	
	public int change(int amount, int[] coins) {
	
		if(coins == null|| coins.length == 0)
			return 0;
		
		int index = 0;
		
		return helper(coins, amount, index);
        
    }
	
	private int helper(int[] coins, int amount, int index)
	{
		if(index == coins.length || amount < 0)
			return 0;
		
		if(amount == 0)
			return 1;
		
		//case1 : do not choose the coin
		int c1 = helper(coins, amount, index +1);
		
		//case2 : choose the coin
		int c2 = helper(coins, amount - coins[index], index);
		
		return c1 + c2;
	}


}
