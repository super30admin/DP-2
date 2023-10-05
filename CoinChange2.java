class Solution {
    public int change(int amount, int[] coins) {
        if (coins == null)
            return 0;
        int m = amount;
        int n = coins.length;
        int[] dp = new int[m + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                // if amount < denomination
                if (j >= coins[i - 1]) {
                    dp[j] = dp[j] + dp[j - coins[i - 1]];
                }
            }
        }
        return dp[m];
    }
}