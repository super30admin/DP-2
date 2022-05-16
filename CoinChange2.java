public class CoinChange2 {
    public int change(int amount, int[] coins) {

        int[] dp = new int[amount + 1];

        dp[0] = 1;

        for (int c : coins)

            for (int i = c; i <= amount; i++)

                dp[i] += dp[i - c];

        return dp[amount];

    }
}
