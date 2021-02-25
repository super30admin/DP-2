// Time Complexity : O(rows * cols)
// Space Complexity : O(rows * cols)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

public class CoinChange2 {
    public int change(int amount, int[] coins) {
        int rows = coins.length + 1;
        int cols = amount + 1;

        int[][] dp = new int[rows][cols];
        dp[0][0] = 1;
        for (int j = 1; j < cols; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (coins[i - 1] > j)
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
            }
        }
        return dp[rows - 1][cols - 1];
    }
}
