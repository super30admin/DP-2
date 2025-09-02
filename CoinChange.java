// Time Complexity : O (m*n) where m the amount and n is the number of coins
// Space Complexity : O (n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/**
 * Using tabulation in dp to keep track of number of ways to create the coins. We start with smallest denomination so that we can re-use the calculation.
 * If the current coin's amount is greater than the amount that we have to make up, then it will be same as previosly calculated step since we can't use the current coin.
 */
class CoinChange {
    public int change(int amount, int[] coins) {
        int m = coins.length;
        int n = amount;
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (j >= coins[i - 1])
                    dp[j] = dp[j] + dp[j - coins[i - 1]];
            }
        }

        return dp[n];
    }
}
