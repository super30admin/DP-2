// Time Complexity : O(amount*coins.length)
// Space Complexity : O(amount*coins.length) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

package problem2;

public class CoinChange2 {
	/* -------------------------------------------------------------------------- */
	/* ----------------------------- BRUTE FORCE -------------------------------- */
	// Time Complexity : O(2^(amount + coins.length))
	// Space Complexity : O(amount + coins.length)
	// Did this code successfully run on Leetcode : Time Limit Exceeded
	// Any problem you faced while coding this : No
	public int coinChange2BruteForce(int amount, int[] coins) {
		if (coins == null || coins.length == 0 || amount == 0) {
			return 0;
		}

		return helper(coins, amount, 0, 0);
	}

	private int helper(int[] coins, int amount, int index, int numWays) {
		// Base Case
		if (amount == 0) {
			return 1;
		}
		if (index >= coins.length || amount < 0) {
			return 0;
		}

		// Choose a coin
		int case1 = helper(coins, amount - coins[index], index, numWays + 1);
		// Don't choose a coin
		int case2 = helper(coins, amount, index + 1, numWays);

		if (case1 == 0) {
			return case2;
		}

		if (case2 == 0) {
			return case1;
		}

		return case1 + case2;
	}

	/* -------------------------------------------------------------------------- */
	/* -------------------------- DYNAMIC PROGRAMMING --------------------------- */
	public int change(int amount, int[] coins) {
		if (coins == null || coins.length == 0) {
			return 0;
		}

		if (amount == 0) {
			return 1;
		}

		int[][] dp = new int[coins.length][amount + 1];

		for (int i = 0; i < coins.length; i++) {
			dp[i][0] = 1;
		}

		for (int j = 1; j <= amount; j++) {
			dp[0][j] = j % coins[0] == 0 ? 1 : 0;
		}

		for (int i = 1; i < coins.length; i++) {
			for (int j = 1; j <= amount; j++) {
				if (coins[i] > j) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i]];
				}
			}
		}
		return dp[coins.length - 1][amount];
	}

	public static void main(String[] args) {
		CoinChange2 obj = new CoinChange2();
		System.out.println("Number of possible ways to obtain amount 12 using coins [1, 2, 3, 5, 10] is "
				+ obj.change(12, new int[] { 1, 2, 3, 5, 10 }));
	}

}
