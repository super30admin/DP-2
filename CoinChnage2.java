class Solution {
    /**
     * Try recursive BF - it will time limit exceed.
     * DP -> 2D array with row -> coins. Column -> sum. Values will be how many ways we can make given sum using given coins.
     */
    public int change(int amount, int[] coins) {
        //edge
        if (coins == null || coins.length == 0) {
            return -1;
        }
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int i = 0; i <= coins.length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];
    }
}
