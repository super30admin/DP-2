class Solution {
    public int change(int amount, int[] coins) {
        // recursion version
        // null case
        if (coins.length == 0 || coins == null)
            return 0;
        int[][] dp = new int[coins.length + 1][amount + 1];
        dp[0][0] = 1;

        return helper(amount, coins, 0);

    }

    private int helper(int amount, int coins[], int index) {
        // base case
        if (amount == 0)
            return 1;
        if (index == coins.length || amount < 0)
            return 0;
        // logic
        // choose
        int case1 = helper(amount - coins[index], coins, index);
        // dont choose
        int case2 = helper(amount, coins, index + 1);
        // fisrt colum
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (j < coins[i - 1]) {
                    // zero case
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // zero and one case
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];

        return case1 + case2;
    }
}