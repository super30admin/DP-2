// Time Complexity: O(m*n)
// Space Complexity: O(m*n)
public class CoinChangeTwo {
    public static void main(String[] args) {
        int[] coins = { 1, 2, 5 };
        int amount = 11;
        int result = coinChange(amount, coins);
        System.out.println("No of ways :: " + result);
    }

    /**
     * 
     * @param amount
     * @param coins
     * @return the number of ways that make up that amount
     */
    public static int coinChange(int amount, int[] coins) {
        int m = coins.length;
        int n = amount;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }

            }
        }
        return dp[m][n];

    }
}