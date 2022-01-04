// Time Complexity :  O(n * amount), where n is number of coins
// Space Complexity : O( amount)
// Did this code successfully run on Leetcode : y
// Any problem you faced while coding this : n
class Solution {
  public int change(int amount, int[] coins) {
    int[] dp = new int[amount + 1];
    dp[0] = 1;

    for (int coin : coins) {
      for (int x = coin; x <= amount; x++) {
        dp[x] += dp[x - coin];
      }
    }
    return dp[amount];
  }
}
