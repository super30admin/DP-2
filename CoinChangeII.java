// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// 1: We maintain a dp table where dp[i][j] contains the total number of ways to make amount j using coins i so far available to us
// 2: We check to make sure that the denomination is greater than the amount, else we will only have case0
// 3: If not, we add case0 and case1 to have the total running sum through which we can return the last element of the dp table
class CoinChangeII {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int m = amount;
        int[][] dp = new int[n + 1][m + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                // denomination > amount
                if (coins[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }
        return dp[n][m];
    }
}