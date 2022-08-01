// Time Complexity : O(mn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

class Solution {
	public int change(int amount, int[] coins) {
		// Recursive approach without storing previous states
//		if (coins == null || coins.length == 0)
//			return 0;
//		return helper(coins, amount, 0);
//	}
//
//	private int helper(int[] coins, int amount, int index) {
//		// base case
//		if (amount == 0)
//			return 1;
//		if (amount < 0 || index == coins.length)
//			return 0;
//
//		// logic
//		// case 1, choose
//		int case1 = helper(coins, amount - coins[index], index);
//
//		// case 2, not choose
//		int case2 = helper(coins, amount, index + 1);
//
//		return case1 + case2;

		// Dynamic programming (Bottom-Up approach)
//		if (coins == null || coins.length == 0)
//			return 0;
//
//		int m = coins.length, n = amount;
//		int[][] dp = new int[m + 1][n + 1];
//		dp[0][0] = 1;
//		for (int i = 1; i <= m; i++) {
//			for (int j = 0; j <= n; j++) {
//				if (j < coins[i - 1]) {
//					dp[i][j] = dp[i - 1][j];
//				} else {
//					dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
//				}
//			}
//		}
//
//		return dp[m][n];

		// Optimal solution
		if (coins == null || coins.length == 0)
			return 0;

		int m = coins.length, n = amount;
		int[] dp = new int[n + 1];
		dp[0] = 1; // 1 0 0 0 0 0 0
		for (int i = 1; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (j >= coins[i - 1]) {
					dp[j] = dp[j] + dp[j - coins[i - 1]];
				}
			}
		}

		return dp[n];
	}
}