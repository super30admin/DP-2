// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

class Solution {
    public int change(int amount, int[] coins) {
        int m = coins.length + 1, n = amount + 1;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i += 1) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < m; i += 1) {
            for (int j = 1; j < n; j += 1) {
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                    continue;
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
            }
        }
        return dp[m - 1][n - 1];
    }
}