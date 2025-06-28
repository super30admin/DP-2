class Solution {
    public int change(int amount, int[] coins) {
        if (coins == null || coins.length == 0) {
            return 0;
        }

        int m = coins.length + 1;
        int n = amount + 1;
        int dp[][] = new int[m][n];

/**
 *   0 1 2 3 4 5
 * 0 1 0 0 0 0 0
 * 1 1
 * 2 1
 * 5 1
 */
        for (int i = 0; i < m; ++i) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                if (coins[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[coins.length][amount];
    }
}