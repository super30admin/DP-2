// Problem: Given the Amount and denominations of the coins, find the total no. of combinations possible. If no combination
// possible, return 0
// Time: O(n * amount), Space: O(amount) where n = no. of coin denominations

public class Coin_Change_2 {
    public int change(int amount, int[] coins) {
        int dp[] = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int x = coin; x <= amount; x++) {
                dp[x] += dp[x - coin];
            }
        }
        return dp[amount];
    }
}