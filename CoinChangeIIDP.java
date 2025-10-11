/**
 * Leet Code : https://leetcode.com/problems/coin-change-ii/description/
 *
 * Approach:
 * This solution uses bottom-up dynamic programming (tabulation) to count the number of ways
 * to make up a given amount using the provided coin denominations. We use a 1D dp array where
 * dp[j] represents the number of ways to make up amount j.
 *
 * - Initialize dp[0] = 1, since there is one way to make amount 0 (use no coins).
 * - For each coin, iterate through all amounts from 1 to amount:
 *     - For each amount j >= coin, add the number of ways to make (j - coin) to dp[j].
 *     - This ensures that each combination is counted only once (order of coins does not matter).
 * - The answer is dp[amount].
 *
 * Time Complexity: O(n * amount), where n is the number of coins.
 * Space Complexity: O(amount) for the dp array.
 */
public class CoinChangeIIDP {

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        // There is one way to make amount 0: use no coins
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                // If current amount j is at least as large as coin value
                if (j >= coins[i])
                    // Add ways to make (j - coin) to ways to make j
                    dp[j] = dp[j] + dp[j - coins[i]];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(new CoinChangeIIDP().change(5, new int[]{1, 2, 5}));
    }
}
