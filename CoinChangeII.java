// Time Complexity : O(coins length * amount)
// Space Complexity : O(coins length * amount)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


/**
 * Take a dp matrix. When the amount= 0 and coins are 0, there is 1 way to achieve it.
 * Similarly when 0 amount and coins are available, there is 1 possible way. For remaining
 * cases, we have to check add two possibilities.
 * 1. Ignore the current coin, so take the no. of ways obtained by using the coins left of it.
 * 2. Take the current coin and deduct that value from the amount. Check the no. of ways obtained
 * by using the coins till the current coin and the value obtained after subtracting current coin.
 * Return the last index of dp matrix which is the final answer.
 *
 */
public class CoinChangeII {
	public int change(int amount, int[] coins) {
		if (amount == 0)
			return 1;

		int[][] dp = new int[coins.length + 1][amount + 1];
		dp[0][0] = 1;
		for (int i = 1; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				if (j < coins[i - 1])
					dp[i][j] = dp[i - 1][j];
				else
					dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
			}
		}
		return dp[coins.length][amount];
	}
}
