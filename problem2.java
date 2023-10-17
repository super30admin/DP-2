//time complexity-O(mxn)
//space complexity-O(mxn)
//passed all test cases on leetcode
//the approach is to go through all the ways and add them up to get the ways.
class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int dp[][] = new int[amount + 1][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i <= amount; i++) {
            if (i % coins[0] == 0)
                dp[i][0] = 1;
            else
                dp[i][0] = 0;
        }
        for (int i = 1; i <= amount; i++) {
            for (int j = 1; j < n; j++) {
                int nottake = dp[i][j - 1];
                int take = 0;
                if (coins[j] <= i) {
                    take = dp[i - coins[j]][j];
                }
                dp[i][j] = take + nottake;
            }
        }
        return dp[amount][n - 1];

    }
}
