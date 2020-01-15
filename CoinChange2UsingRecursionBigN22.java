// The time complexity is O(M*N) where M is the amount and N is the number of denomination
// Space complexity is O(M+N)
// This solution gives time limit Exceed

public class CoinChange2UsingRecursionBigN22 {
	public int change(int amount, int[] coins) {
		return helper(coins, amount,0);
	}

	private int helper(int[] coins, int amount, int index) {
		// base case
		if (amount == 0)
			return 1;
		if (amount < 0 || index >= coins.length)
			return 0; 
		// logic
		// case 1: not choosing the coin
		int case1 = helper(coins, amount, index + 1);
		// case 2: We are choosig a coin
		int case2 = helper(coins, amount - coins[index], index);
		return case1 + case2;
	}
}
