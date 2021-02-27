// Here we build the DP array to find the number of ways to reah a given amount with the given set of coins

// Time Complexity : O(n * amount) where n is the number of coins
// Space Complexity : O(n * amount)

public class CoinChange2 {
    public static int change(int amount, int[] coins) {
        int m = coins.length + 1, n = amount + 1;
        int[][] dp = new int[m][n];
        dp[0][0] = 1;

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (coins[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[] coins = { 1, 2, 5 };
        int amount = 5;

        System.out.println("Number of ways : " + change(amount, coins));
    }
}