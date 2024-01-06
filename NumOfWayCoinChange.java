
class NumOfWayCoinChange {
    public int change(int amount, int[] coins) {
        // int result = helper(amount, coins, 0);
        if(coins == null || coins.length == 0) return 0;

        int n = coins.length;
        int m = amount;

        int[] dp = new int[m+1];
        // Arrays.fill(dp[0], 0);
        dp[0] = 1;

        for(int i = 1 ; i <= n; i++) {
            for(int j = 0; j <= m; j++) {
                if (j < coins[i-1]) {
                    dp[j] = dp[j];
                } else {
                    dp[j] = dp[j] + dp[j - coins[i-1]];
                }
            }
        }

        return dp[m];
    }

    private int helper(int amount, int[] coins, int idx) {
        //
        if(idx == coins.length || amount < 0) return 0;

        if(amount == 0) return 1;
        // chose
        int case1 = helper(amount - coins[idx], coins, idx);

        //not choose
        int case2 = helper(amount, coins, idx + 1);

        return case1 + case2;
    }
}