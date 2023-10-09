//Time: O(n), Space: O(n)
class Solution {
    public int minCost(int[][] costs) {
        int m = costs.length;
        int n = costs[0].length;

        int[][] dp = new int[m + 1][n];
        for (int i = 0; i < n; i++) {
            dp[m][i] = 0;
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    dp[i][j] = costs[i][j] + Math.min(dp[i + 1][1], dp[i + 1][2]);
                } else if (j == 1) {
                    dp[i][j] = costs[i][j] + Math.min(dp[i + 1][0], dp[i + 1][2]);
                } else {
                    dp[i][j] = costs[i][j] + Math.min(dp[i + 1][0], dp[i + 1][1]);
                }
            }
        }
        return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2])); 
    }
}
