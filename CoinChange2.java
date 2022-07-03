// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no 

class Solution {
    public int change(int amount, int[] coins) {
        if (coins == null || coins.length == 0)
            return 0;

        int m = coins.length;
        int n = amount;
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < m + 1; i++) { // the first column is 1.
            dp[i][0] = 1;
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j]; // when only 0 case is available.
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]]; // when both 0 case and 1 case is available,
                                                                       // consider both ways, therefore sum.

                }
            }
        }
        return dp[m][n]; // the asnwer is the last cell of the dp table.

    }
}