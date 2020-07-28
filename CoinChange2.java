class CoinChange2{
 public int change(int amount, int[] coins) {
         int[] dp = new int[amount + 1];
    dp[0] = 1;
    for (int i= 0; i < coins.length; i++) {
    	for (int j = coins[i]; j <= amount; j++)
    		dp[j] = dp[j - coins[i]] + dp[j];
    }
    return dp[amount];
    }
//TIme complexity : O(coins * amount)
//Space Complexity : O(amount)
}