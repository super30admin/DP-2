// Time Complexity O(m*n)
// Space Complexity O(m*n)
// Runs on LeetCode: Yes

public class CoinChange2 {
    public int change(int amount, int[] coins) {
        int rows = coins.length;
        int cols = amount;
        int[][] dp = new int[rows + 1][cols + 1];

        dp[0][0] = 1;

        for (int j = 1; j < cols; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= rows; i++) {
            for (int j = 0; j <= cols; j++) {
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }

            }
        }
        return dp[rows][cols];
    }
}