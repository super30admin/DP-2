class Solution {
    public int change(int amount, int[] coins) {
        int dp[] = new int[amount + 1];

        dp[0] = 1;
        for (int i = 0; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    dp[i] = dp[i - coins[j]] + dp[i];
                }
            }
        }
        return dp[amount];
    }
}