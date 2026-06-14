class Solution {
    // SC - O(3n) = O(n)
    // TC - O(3n) = O(n)
    public int minCost(int[][] costs) {
        int n = costs.length;
        int[][] dp = new int[n][3];

        if (n == 1) {
            return Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2]));
        }
        
        for (int i = 0; i < 3; i++) {
            dp[0][i] = costs[0][i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    dp[i][j] = costs[i][j] + Math.min(dp[i-1][1], dp[i-1][2]);
                }
                if (j == 1) {
                    dp[i][j] = costs[i][j] + Math.min(dp[i-1][0], dp[i-1][2]);
                }
                if (j == 2) {
                    dp[i][j] = costs[i][j] + Math.min(dp[i-1][1], dp[i-1][0]);
                }
            }
        }

        return Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2]));
    }
}