// Time Complexity :O(n*amount) where n is length of coins array
// Space Complexity :O(amount)
public class CoinTwo {

        public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
          for (int i = coin; i<=amount; i++) {
            dp[i] += dp[i - coin];
          }
        }
        return dp[amount];
        }
    
}
