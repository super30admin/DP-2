// Time Complexity : O(S * n) //S is amount and n is coins length
// Space Complexity : O(S * n) //dp array size
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


/**
 * 1. Form a DP table with multi dimensional array.
 * 2. For every coin there will be 2 options choose or not to choose. 
 * 3. If not chosen coin will be removed and count will be same.
 * 4. If chosen coin considered again and count will be added by 1. 
 */

public class CoinChange2 {
	public int change(int amount, int[] coins) {

		int rows = coins.length;
		int[][] dp = new int[rows + 1][amount + 1];

		for (int row = 0; row < dp.length; row++) {
			dp[row][0] = 1;
		}

		for (int row = 1; row < dp.length; row++) {
			for (int col = 1; col < dp[0].length; col++) {
				// not chosen
				if (col < coins[row - 1]) {
					dp[row][col] = dp[row - 1][col];
				} else {
					// chosen
					dp[row][col] = dp[row - 1][col] + dp[row][col - coins[row - 1]];
				}
			}
		}
		return dp[dp.length - 1][dp[0].length - 1];

	}

	public static void main(String[] args) {
		System.out.println(new CoinChange2().change(5, new int[] { 1, 2, 5 }));
	}
}
