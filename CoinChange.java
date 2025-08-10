// Time Complexity  : O(m * n)  // m = number of coins, n = amount
// Space Complexity : O(n)      // dp array of size amount+1
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach:
// We use a 1D DP array where dp[j] represents the number of ways to make amount 'j'.
// Initialize dp[0] = 1 (1 way to make amount 0 — by choosing nothing).
// For each coin, update dp[j] for all j >= coin value.
// This ensures combinations (order doesn’t matter) rather than permutations.

class CoinChange {
    public int change(int amount, int[] coins) {
        int m = coins.length;
        int n = amount;
        int[] dp = new int[n + 1];

        dp[0] = 1; // Base case: 1 way to make amount 0

        for (int i = 1; i <= m; i++) { // iterate over coins
            for (int j = 1; j <= n; j++) { // iterate over amounts
                if (j >= coins[i - 1]) {
                    // Add ways to make (j - current coin value)
                    dp[j] = dp[j] + dp[j - coins[i - 1]];
                }
                // else: dp[j] remains unchanged (coin too big to use)
            }
        }
        return dp[n];
    }

    // Main method for testing
    public static void main(String[] args) {
        CoinChange sol = new CoinChange();
        int amount = 5;
        int[] coins = {1, 2, 5};
        System.out.println("Number of combinations: " + sol.change(amount, coins));
    }
}