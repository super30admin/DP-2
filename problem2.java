// Time Complexity : O(n * amount)
// Space Complexity : O(n * amount) we use 2-D DP array of the size
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// For each coin, the algorithm fills up the dp matrix iteratively, considering
// the combinations needed to reach each amount using the current coin and the previously calculated combinations.
class problem2 {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= amount; i++) {
            dp[0][i] = 0;
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j <= amount; j++) {
                if (coins[i] > j) {
                    dp[i][j] = dp[i + 1][j];
                } else {
                    dp[i][j] = dp[i + 1][j] + dp[i][j - coins[i]];
                }
            }
        }

        return dp[0][amount];
    }
}