// TC = 0(m*n)
// SC = 0(m*n)

public class CoinChangeTwo {

    public static void main(String[] args) {

        int[] arr = { 1, 2, 5 };

        int amount = 5;

        CoinChangeTwo obj = new CoinChangeTwo();

        int obj1 = obj.search(arr, amount);

        System.out.println("total num " + obj1);
    }

    public int search(int[] coins, int amount) {

        if (coins == null || coins.length == 0)
            return 0;

        int m = coins.length;
        int n = amount;
        int[][] dp = new int[m + 1][n + 1];

        // first row

        dp[0][0] = 1;

        for (int i = 1; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
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
