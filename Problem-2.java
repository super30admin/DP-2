// Time Complexity : O(m x n) [m: amount; n: no. of coins]
// Space Complexity : O(m x n) [m: amount; n: no. of coins]
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

// Here we construct a dp table, similar to coin change problem 1.
// But instead of storing Minimum coins in DP, we will be storing the ways in which we can get to the amount
class Solution2 {
    public int change(int amount, int[] coins) {
        if (coins == null || coins.length == 0)
            return 0;

        int[][] dp = new int[coins.length + 1][amount + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                // check if denomination of coin is less than amount
                if (j < coins[i - 1]) {
                    // Zero case: immediate above value in table
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // Zero case and get value from denomination column
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }

        // result in last element
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
