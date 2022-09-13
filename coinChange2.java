// Time Complexity : O(mn)
// Space Complexity : O(m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None.


// Your code here along with comments explaining your approach


class Solution {
    
	public int change(int amount, int[] coins) {
		 
		 if (coins == null || coins.length == 0) return 0;

		 int n = amount;
		 int m = coins.length;
		 int[] dp = new int[n+1];
		 
		 dp[0] = 1;
		 
		 for(int i = 1; i <= m; i++) {
			  for(int j = 0; j <= n; j++) {
					if (j < coins[i-1]) {
						 dp[j] = dp[j];
					} else {
						 dp[j] = dp[j] + dp[j - coins[i-1]];
					}
			  }
		 }
		 return dp[n];
		 // return helper(amount, coins,0, 0);
	}
	
	
	// Recursive - Time limit exceeded
	private int helper(int amount, int[] coins, int idx, int sum) {
		 //base
		 if(idx == coins.length || sum > amount) 
			  return 0;
		 
		 //logic
		 if(sum == amount) {
			  return 1;
		 }
		 
		 // choose
		 int case0 = helper(amount, coins, idx, sum+coins[idx]);
		 
		 // not choose
		 int case1 = helper(amount, coins, idx+1, sum);
		 
		 return case0 + case1;
	}
}