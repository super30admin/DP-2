/*
 * Time Complexity - Recursive: O(2^n), where n = target amount
 * Time Complexity - DP: O(n * m), where n = number of coins, m = amount
 *
 * Space Complexity - Recursive: O(n) due to recursion stack
 * Space Complexity - DP: O(n * m) for the 2D dp table
 *
 * Approach -
 * Recursive:
 * - At each step, I decide whether to:
 *     1. Take the current coin (remain at the same index and reduce the amount)
 *     2. Skip the current coin (move to the next index)
 * - I increment the count only when the target amount is matched exactly.
 * - If amount exceeds target or index reaches end, return 0 (invalid path).
 * 
 * DP:
 * - I use a 2D table dp[i][j], where:
 *     - i = number of coins considered
 *     - j = target amount
 * - dp[0][0] = 1 → one way to make amount 0 with 0 coins
 * - For each coin and amount, I compute:
 *     - dp[i-1][j] → ways excluding current coin
 *     - dp[i][j - coins[i-1]] → ways including current coin (can be reused)
 * - Final answer is at dp[n][m], which gives total unique combinations (order doesn't matter).
 */

public class Problem_1 {
    static int coin_change_recursive(int[] coins, int amount) {
        int res = helper(coins, 0, 0, amount);
        return res;
    }

    static int helper(int[] coins, int idx, int amount, int target) {
        if (amount == target) {
            return 1;
        }
        if (amount > target || idx == coins.length) {
            return 0;
        }
        int take = helper(coins, idx + 1, amount, target);
        int notake = helper(coins, idx, amount + coins[idx], target);
        return take + notake;
    }

    static int coin_change_dp(int[] coins, int amount) {
        int n = coins.length;
        int m = amount;
        int[][] dp = new int[n + 1][m + 1];
        dp[0][0] = 1;
        for (int j = 1; j <= m; j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        int[] coins = { 1, 2, 5 };
        int amount = 11;
        System.out.println(coin_change_dp(coins, amount));
    }
}