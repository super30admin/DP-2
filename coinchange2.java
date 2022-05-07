
// Did this code successfully run on Leetcode :Yes
class Solution {
    public int change(int amount, int[] coins) {
        if (amount < 0 || coins == null || coins.length == 0) {
            return amount == 0 ? 1 : 0;
        }

        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int i = 0; i <= coins.length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                dp[i][j] = dp[i - 1][j];

                if (j - coins[i - 1] >= 0) {
                    dp[i][j] += dp[i][j - coins[i - 1]];
                }
            }
        }

        return dp[coins.length][amount];
    }
}
