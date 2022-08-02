class Solution {
    /*
     * Time Complexity - O(m*n)
     * Space Complexity - O(m*n)
     */
    public int change(int amount, int[] coins) {
        int m = coins.length, n = amount;
        int[][] dp = new int[m+1][n+1];
        // 0 amount can be formed from 0 coin
        dp[0][0] = 1;
        for (int i=1; i<dp.length; i++) {
            for (int j=0; j<dp[0].length; j++) {
                if (j<coins[i-1])
                    dp[i][j] = dp[i-1][j];
                else {
                    // add up all combinations
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[m][n];
    }
}