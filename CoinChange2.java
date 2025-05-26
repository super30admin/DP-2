public class CoinChange2 {
    // ----------------- Solution 1
    /**
     * Memoization solution DP
     */
    int[][] memo;
    public int change(int amount, int[] coins) {
        int m = coins.length;
        int n = amount;
        memo = new int[m+1][n+1];

        //fill memo with -1 to mark no results calculated so far
        for(int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                memo[i][j] = -1;
            }
        }
        return helper(coins, 0, amount);
    }

    private int helper(int[] coins, int idx, int amount) {
        //base
        if(amount == 0) return 1;
        if(amount < 0 || idx == coins.length) return 0;

        if(memo[idx][amount] != -1) {
            return memo[idx][amount];
        }

        //no choose
        int case1 = helper(coins, idx + 1, amount);

        //choose
        int case2 = helper(coins, idx, amount - coins[idx]);
        memo[idx][amount] = case1 + case2;
        return memo[idx][amount];
    }

    // ---------------- Solutoin 2 ----------------
    /**
     * 2D array tabulation DP solution
     * Time O(m*n) Space same
     */
    public int change2(int amount, int[] coins) {
        int m = coins.length;
        int n = amount;
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 1;

        for(int i = 1; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                //amount < denomination
                if (j < coins[i -1]) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
                }
            }
        }
        return dp[m][n];
    }

    // ------------- Solution 3
    /**
     * Space optimized 1D array tabulation DP
     * Time O(m*n) Space O(n)
     */
    public int change3(int amount, int[] coins) {
        int m = coins.length;
        int n = amount;
        int[] dp = new int[n+1];
        dp[0] = 1;

        for(int i = 1; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                //amount < denomination
                if (j < coins[i -1]) {
                    dp[j] = dp[j];
                } else {
                    dp[j] = dp[j] + dp[j - coins[i-1]];
                }
            }
        }
        return dp[n];
    }
}
