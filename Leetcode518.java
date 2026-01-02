class Solution {
    public int change(int amount, int[] coins) {
        // //Solution 1 = 2D DP Matrix
        // // TC : O(nm)
        // // SC : O(nm)
        // int m = coins.length;
        // int n = amount;
        // int[][] dp = new int[m+1][amount+1]; // 0 row and 0 amount
        // dp[0][0] = 1;

        // for(int i=1; i<= m; i++) {
        // for(int j =0; j<=n; j++) {
        // if(j<coins[i-1]) {

        // dp[i][j] = dp[i-1][j];
        // } else {
        // dp[i][j] = dp[i][j-coins[i-1]] + dp[i-1][j];
        // }

        // }
        // }

        // return dp[m][n];

        // Solution 1 = 2D DP Matrix
        // TC : O(n)
        // SC : O(n)
        int m = coins.length;
        int n = amount;
        int[] dp = new int[amount + 1]; // 0 row and 0 amount
        dp[0] = 1;

        for (int i = 1; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (j >= coins[i - 1]) {
                    dp[j] = dp[j - coins[i - 1]] + dp[j];
                }

            }
        }

        return dp[n];

    }
}
