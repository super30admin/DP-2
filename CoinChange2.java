public class CoinChange2 {
    public int change(int amount, int[] coins) {
        // return coinChangeExhaustiveSearch(amount, coins);
        // return coinChangeTwoDimensionalDP(amount, coins);
        return coinChangeOneDimensionalDP(amount, coins);
    }

    private int coinChangeOneDimensionalDP(int amount, int[] coins) {
        int m = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int i = 1; i <= m; i++) {
            for (int j = 0; j <= amount; j++) {
                if (j < coins[i - 1]) {
                    dp[j] = dp[j];
                } else {
                    dp[j] += dp[j - coins[i - 1]];
                }
            }
        }
        return dp[amount];
    }

    private int coinChangeTwoDimensionalDP(int amount, int[] coins) {
        int m = coins.length;
        int[][] dp = new int[m + 1][amount + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= m; i++) {
            for (int j = 0; j <= amount; j++) {
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }
        return dp[m][amount];
    }

    private int coinChangeExhaustiveSearch(int amount, int[] coins) {
        return helper(amount, coins, 0);
    }

    private int helper(int amount, int[] coins, int start) {
        if (amount < 0 || start == coins.length) return 0;
        if (amount == 0) return 1;
        int notChoose = helper(amount, coins, start + 1);
        int choose = helper(amount - coins[start], coins, start);
        return notChoose + choose;
    }
}
