package s30.week2;

public class CoinChange2 {

    public int coinChange2(int[] coins, int amount) {
        int m = coins.length;
        int n = amount;
        int[][] dp = new int[m+1][n+1];

        dp[0][0] = 1;

        for (int i = 1 ; i <= m ; i++) {
            for (int j = 0; j <= n ; j++) {
                if(j < coins[i-1]) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[m][n];
    }

    public int coinChangeDP(int[] coins, int amount) {
        int totalWays = helper(coins, amount, 0);
        return totalWays;
    }

    private int helper(int[] coins, int amount, int i) {

        if(i == coins.length || amount < 0) return 0;

        if(amount == 0) return 1;
        //pick
        int case0 = helper(coins, amount, i+1);

        //don't pick
        int case1 = helper(coins, amount - coins[i], i);

        return case0 + case1;

    }

}
