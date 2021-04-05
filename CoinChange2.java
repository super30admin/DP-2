// Time Complexity :O(mn)
// Space Complexity :O(mn)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :

class Solution {
    public int change(int amount, int[] coins) {
        if (coins == null)
            return 0;
        int[][] dp = new int[coins.length + 1][amount + 1];
        // Fill the first column with 1 since the no. of ways to choose 0 would be 1

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                // Copy the previous value if coin value greater than the amount
                if (coins[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // Add the previous combination with the calue included with the current coin
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }

            }

        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}