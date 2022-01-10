// Time Complexity : O(m*n)
// Space Complexity : O(m*n) where m = coins.length and n = amount
// Did this code successfully run on Leetcode : Yes

public class CoinChange2 {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];

        //  base
        dp[0][0] = 1;

        //  first column is always 1
        for (int i = 1; i < dp.length; ++i) {
            dp[i][0] = 1;
        }

        //  filling rest of the matrix
        for (int i = 1; i < dp.length; ++i) {
            for (int j = 1; j < dp[0].length; ++j) {
                if (coins[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                }
                else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];
    }
}
