
public class CoinChange2 {

    public int change(int amount, int[] coins) {
        if (amount == 0) {
            return 1;
        }
        if (coins == null || coins.length == 0 || amount < 0) {
            return 0;
        }

        int[] dp = new int[amount + 1];
        dp[0] = 1;


        for (int c : coins) {
            for (int i = c; i <= amount; i++) {
                dp[i] = dp[i] + dp[i - c];
            }
        }

        return dp[amount];
    }

    public static void main(String[] args) {
        CoinChange2 sol = new CoinChange2();

        int amount = 5;
        int[] coins = {1, 2, 5};

        int totalWays = sol.change(amount, coins);
        System.out.println("Total combinations to make amount " + amount + ": " + totalWays); // Output: 4
    }
}

