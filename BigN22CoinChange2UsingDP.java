// Time complexity is O(row*column)
// Space complexity is also O(row*column)
// This solution is submitted on leetcode

public class BigN22CoinChange2UsingDP {
	public int change(int amount, int[] coins) {
		if((coins.length == 0 && amount !=0)|| coins == null)
			return 0;
		int row = coins.length + 1;
		int column = amount + 1;
		int[][] dp = new int[row][column];
		for (int i = 0; i < row; i++) {
			dp[i][0] = 1;
		}
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < column; j++) {
				if (j < coins[i - 1]) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
				}
			}
		}
		return dp[row - 1][column - 1];
	}
}
