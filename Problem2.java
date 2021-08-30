//T:O(mn) where m is length of coins array and n is amounts possible

//S:O(n)


class Solution {
    public int change(int amount, int[] coins) {
    int[] dp = new int[amount + 1];
    dp[0] = 1; //no coins 

    for (int coin : coins) {
      for (int x = coin; x < amount + 1; ++x) {
        dp[x] += dp[x - coin];
      }
    }
    return dp[amount];
  }
}
