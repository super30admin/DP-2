//Coin change 2 using Rec
public class CoinChange2UsingRec {
	public int change(int amount, int[] coins) {
		if (coins == null)
			return 0;

		return helper(coins, amount, 0);

	}

	private int helper(int[] coins, int amount, int index) {
		// base
		if (amount == 0)
			return 1;

		if (amount < 0 || index == coins.length)
			return 0;

		// logic
		int case1 = helper(coins, amount - coins[index], index);
		int case2 = helper(coins, amount, index + 1);

		return case1 + case2;

	}
}
