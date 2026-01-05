import java.util.Arrays;

/*
COIN CHANGE II (LeetCode 518)

We solve this problem using multiple approaches:

1) Pure Recursion (Exponential)
2) Top-Down DP (Recursion + Memoization)
3) Bottom-Up DP (2D Matrix)
4) Bottom-Up DP (1D Optimized)

Key Difference from Coin Change I:
- Coin Change I → MIN coins
- Coin Change II → COUNT number of ways

State idea:
dp[i][j] = number of ways to make amount j using first i coins
*/

public class CoinChangeII {
    /*1) PURE RECURSION  */
    public int changeRecursive(int amount, int[] coins) {
        return helperRecursive(amount, coins, 0);
    }

    private int helperRecursive(int amount, int[] coins, int index) {
        if (amount == 0) return 1;                 // found one valid way
        if (amount < 0 || index == coins.length) return 0;

        // choice: skip coin OR take coin
        int skip = helperRecursive(amount, coins, index + 1);
        int take = helperRecursive(amount - coins[index], coins, index);

        return skip + take;
    }

    /* 2) TOP-DOWN DP (Memoization) */
    private int[][] memo;

    public int changeTopDown(int amount, int[] coins) {
        memo = new int[coins.length][amount + 1];
        for (int i = 0; i < coins.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        return helperTopDown(amount, coins, 0);
    }

    private int helperTopDown(int amount, int[] coins, int index) {
        if (amount == 0) return 1;
        if (amount < 0 || index == coins.length) return 0;

        if (memo[index][amount] != -1) {
            return memo[index][amount];
        }

        int skip = helperTopDown(amount, coins, index + 1);
        int take = helperTopDown(amount - coins[index], coins, index);

        memo[index][amount] = skip + take;
        return memo[index][amount];
    }

    /*3) BOTTOM-UP DP (2D Matrix)*/
    public int change2D(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];

        // Base case: 1 way to make amount 0 (choose nothing)
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j]; // can't take coin
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }

        return dp[n][amount];
    }

    /* 4) BOTTOM-UP DP (1D Optimized) */
    public int change1D(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1; // one way to make amount 0

        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] += dp[j - coin];
            }
        }

        return dp[amount];
    }
}
