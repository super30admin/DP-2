public class HousePaint {
    public int minCost(int[][] cost) {
        // Write your code here.
        if (cost == null || cost.length == 0)
            return 0;
        int n = cost.length;
        int dp[][] = new int[n][3];
        dp[n - 1][0] = cost[n - 1][0];
        dp[n - 1][1] = cost[n - 1][1];
        dp[n - 1][2] = cost[n - 1][2];
        for (int i = n - 2; i >= 0; i--) {
            dp[i][0] = cost[i][0] + Integer.min(dp[i + 1][1], dp[i + 1][2]);
            dp[i][1] = cost[i][1] + Integer.min(dp[i + 1][0], dp[i + 1][2]);
            dp[i][2] = cost[i][2] + Integer.min(dp[i + 1][0], dp[i + 1][1]);
        }
        return Integer.min(dp[0][0], Integer.min(dp[0][1], dp[0][2]));
    }
}
