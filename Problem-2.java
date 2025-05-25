/**
 * Approach:
 * - Goal: Find the number of ways to make up a target amount using unlimited coins.
 * - Initialize a dp array where `dp[i]` represents the number of combinations to make amount `i`.
 * - Set `dp[0] = 1` as base case (1 way to make amount 0).
 * - For each coin:
 *   - Update `dp[a]` for all `a` from coin to amount by adding `dp[a - coin]`.
 *   - This ensures we count all combinations that include the current coin.
 * - After processing all coins, `dp[amount]` contains the total number of combinations. 
 */
// Time Complexity : O(amount * N)
// Space Complexity : O(amount)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1; // One way to make amount 0 — use no coins
        for (int c : coins) {
            // For each coin, update combinations for all amounts >= coin
            for (int a = c; a <= amount; a++) {
                dp[a] += dp[a - c]; // Add ways to make (a - c)
            }
        }
        return dp[amount]; // Total combinations to form target amount
    }
}

