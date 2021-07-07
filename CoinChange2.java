//Time Complexity : O(N^2)
//Space Complexity : O(N)
//Did this code successfully run on Leetcode : yES
//Any problem you faced while coding this :nO


//Your code here along with comments explaining your approach
public class CoinChange2 {
	public int change(int coins[], int amount) {
		if (amount <= 0 || coins == null || coins.length == 0)
			return 0;
		int dp[] = new int[amount + 1];
		dp[0] = 1;
		for (int coin : coins) {
			for (int j = coin; j <= amount; j++) {
				dp[j] += dp[j - coin];
			}
		}
		return dp[amount];

	}

	public static void main(String args[]) {
		int coins[] = {};
		int amount = 0;

		CoinChange2 coin = new CoinChange2();

		System.out.println(coin.change(coins, amount));
	}
}
