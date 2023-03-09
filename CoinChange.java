/*this implementation uses dynamic programming approach to determine the number of combinations
 * the time complexity of this approach is O(amount * n)*/
public class CoinChange {
    public static int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= amount; j++) {
                dp[i][j] = dp[i-1][j];
                if (j >= coins[i-1]) {
                    dp[i][j] += dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[n][amount];
    }
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 5;
        int result = change(amount, coins);
        System.out.println("Number of combinations: " + result);
    }
}
