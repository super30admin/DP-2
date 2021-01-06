// Time Complexity : O(mn)  (m = no of coins & n = amount)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    public int change(int amount, int[] coins) {
        if(coins == null || coins.length == 0) return 0;

        int rows = coins.length + 1;
        int cols = amount + 1;

        //Each DP cell depicts the no of ways to make the sum using given coins
        int[][] dp = new int[rows][cols];

        dp[0][0] = 1; //Making sum 0 with amount 0 has only 1 possible way

        for(int i = 1; i < rows; i++) {
            for(int j = 0; j < cols; j++) {

                if(coins[i-1] > j) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    int case1 = dp[i-1][j];
                    int case2 = dp[i][j - coins[i-1]];
                    dp[i][j] = case1 + case2;
                }
            }
        }

        return dp[rows-1][cols-1];
    }
}
