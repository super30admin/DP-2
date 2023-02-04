import java.util.Arrays;

public class CoinChange2 {

	// TC: o(m*n) m is no .of coins, n is amount
	// SC: o(n) n is number of coins
	public static int changeWith1DArray(int amount, int[] coins) {

		if (coins == null || coins.length == 0)
			return -1;

		int m = coins.length;
		int n = amount;

		int[] dp = new int[n + 1];

		// only one row, first element is 1 and remaining are zeros
		dp[0] = 1;

		// iterate through coins
		for (int i = 1; i <= m; i++) {
			// iterate through amount
			for (int j = 0; j <= n; j++) {
				// update amount only if sum is greater than or equal to coin
				if (j >= coins[i - 1]) {
					// update with current value + value of coin number steps back
					dp[j] = dp[j] + dp[j - coins[i - 1]];
				}
			}
		}
		System.out.println("dp array" + Arrays.toString(dp));
		return dp[n];
	}

	public static void main(String args[]) {
		int[] coins = { 1, 2, 5 };
		changeWith1DArray(11, coins);
	}

	// TC: o(m*n) m is no .of coins, n is amount
	// SC: o(m*n) m is no .of coins, n is amount
	public int changeWith2DArray(int amount, int[] coins) {

		if (coins == null || coins.length == 0)
			return -1;

		int m = coins.length;
		int n = amount;

		int[][] dp = new int[m + 1][n + 1];

		dp[0][0] = 1;

		// we already made i=0 row,
		// dp[0][0] as 1 and remaining as zero
		// as java defaults to zero we are not processing again
		for (int i = 1; i < dp.length; i++) {
			// we have to consider j=0 row as they are non zeros in this case
			for (int j = 0; j < dp[0].length; j++) {
				if (j < coins[i - 1]) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
				}
			}
		}
		return dp[m][n];
	}

	// TC: o(2^m+n) Time Limit Exceeded
	public int changeExhaustMethod(int amount, int[] coins) {

		if (coins == null || coins.length == 0)
			return -1;

		return helper(coins, amount, 0);
	}

	private int helper(int[] coins, int amount, int index) {
		// base
		if (amount == 0)
			return 1;

		if (amount < 0 || index == coins.length)
			return 0;

		// choose
		int case1 = helper(coins, amount - coins[index], index);

		// not choose
		int case0 = helper(coins, amount, index + 1);

		return case1 + case0;
	}
}
