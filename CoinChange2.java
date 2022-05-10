/**
 * // Time Complexity : O(n)
 * // Space Complexity : O(n)
 * // Did this code successfully run on Leetcode : Yes
 */
public class CoinChange2 {
  public static int coinChange(int[] coins, int amount) {
    int[] dp = new int[amount + 1];
    dp[0] = 1;
    for (int i = 0; i < coins.length; i++) {
      for (int j = coins[i]; j <= amount; j++) {
        dp[j] = dp[j] + dp[j - coins[i]];
      }
    }
    return dp[amount];
  }

  public static void main(String[] args) {
    int amount = 5;
    int[] coins = { 1, 2, 5 };
    int result = coinChange(coins, amount);
    System.out.println(result);
  }

}