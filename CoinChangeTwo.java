class CoinChangeTwo {

    //tabularization
    //complexity : O(M*N)
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int m = amount;
        int[][] dp = new int[n+1][m+1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (j < coins[i - 1])
                    dp[i][j] = dp[i-1][j];
                else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }
        return dp[n][m];
    }

    //memoization
    //complexity : O(M*N) 
    // int[][] memo;

    // private int helper(int[] coins, int amount, int idx) {
    //     //base 
    //     if (amount == 0)
    //         return 1;

    //     if (amount < 0 || coins.length == idx)
    //         return 0;
    //     // logic 

    //     if (memo[idx][amount] != -1)
    //         return memo[idx][amount];

    //     //no choose 
    //     int noChoose = helper(coins, amount, idx + 1);
    //     int choose = helper(coins, amount - coins[idx], idx);
    //     memo[idx][amount] = noChoose + choose;

    //     return memo[idx][amount];
    // }

    // public int change(int amount, int[] coins) {

    //     int n = coins.length + 1;
    //     int m = amount + 1;
    //     this.memo = new int[n][m];

    //     for (int i = 0; i < n; i++) {
    //         for (int j = 0; j < m; j++) {
    //             memo[i][j] = -1;
    //         }
    //     }
    //     return helper(coins, amount, 0);

    // }
}