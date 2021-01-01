// Time Complexity : o(n*amount)
// Space Complexity : o(amount)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
  public int change(int amount, int[] coins) {
    int[] dp = new int[amount + 1];
    dp[0] = 1;

    for (int coin : coins) 
    {
      for (int x = coin; x < amount + 1; ++x) 
      {
        dp[x] += dp[x - coin];
      }
    }
    return dp[amount];
  }
}