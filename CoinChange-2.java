// Time Complexity : O(2^n)
// Space Complexity : O(2^n)
// Did this code successfully run on Leetcode : Yes
// Description: Recursive Solution

class Solution{
	public int change(int[] coins, int amount){
		if(coins == null || costs.length==0){
			return 0;
		}
		
		return helper(amount, coins, 0);
	}
	
	private int helper(int[][] costs, int i, int j, int amount){
		//base case
		if(amount == 0){
			return 1;
		}
		if(amount < 0 || i> coins.length -1){
			return 0;
		}
		
		//Case 1 CHoose a coin
		int case1 = helper(amount - coins[i], coins, i);
		//Case 1 Don't choose a coin
		int case2 = helper(amount , coins, i+1);
		
		return case1 + case2;
	}
}

// Time Complexity : O(n^2)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : Yes
// Description: DP Solution
class Solution{
	public int change(int amount, int[] coins ){
		
		int[][] dp = new int[coins.length + 1][amount + 1];
		
		int m = dp.length;
		int n = dp[0].length;
		dp[0][0] = 1;
		for(int i=1;i<m;i++){
			dp[i][0] = 1;
			for(int j=1;j<n;j++){
				if(j < coins[i-1]){
					dp[i][j] = dp[i-1][j];
				}
				else{
					dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]] ;
				}
			}
		}
		return dp[m-1][n-1];
	}
}
