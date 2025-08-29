// Time complexity- O(m*n), m= number of coins, n = amount
// Space complecity - O(n)
function maxNumberOfCombinationForChange(
	amount: number,
	coins: number[]
): number {
	const dp: number[] = new Array(amount + 1).fill(0);
	dp[0] = 1;

	for (let coin of coins) {
		for (let i = coin; i <= amount; i++) {
			// dp[i - coin] = number of combinations for the remaining amount after using the current coin.
			dp[i] = dp[i] + dp[i - coin];
		}
	}
	return dp[amount];
}
