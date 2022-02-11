// Time Complexity : O(nm) where n is length of coins and m is amount
// Space Complexity : O(n) where n is amount
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// LC- 518 Coin Change 2

class CoinChange2 {
  public int change(int amount, int[] coins) {
    if (amount == 0) {
      return 1;
    }

    if (coins == null || coins.length == 0) {
      return 0;
    }

    int[] dp = new int[amount + 1];
    dp[0] = 1;

    for (int coin : coins) {
      for (int i = coin; i < amount + 1; i++) {
        dp[i] = dp[i] + dp[i - coin];
      }
    }

    return dp[amount];
  }
}