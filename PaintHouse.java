public class PaintHouse {
    public int minCost(int[][] costs) {
        // return minCostTwoDimensionalDP(costs);
        return minCostDPWithoutSpace(costs);
    }

    // TC: O(N) where N is the number of houses
    // SC: O(1)
    private int minCostDPWithoutSpace(int[][] costs) {
        int m = costs.length, n = 3;
        int costR = costs[0][0], costB = costs[0][1], costG = costs[0][2];

        for (int i = 1; i < m; i++) {
            int tempR = costR;
            costR = costs[i][0] + Math.min(costB, costG);
            int tempB = costB;
            costB = costs[i][1] + Math.min(tempR, costG);
            costG = costs[i][2] + Math.min(tempR, tempB);
        }

        return Math.min(costR, Math.min(costB, costG));
    }


    // TC: O(N) where N is the number of houses
    // SC: O(K * N) where K is the number of colors and N is the number of houses
    private int minCostTwoDimensionalDP(int[][] costs) {
        int m = costs.length, n = 3;
        int[][] dp = new int[m][n];
        for (int j = 0; j < n; j++) {
            dp[0][j] = costs[0][j];
        }
        for (int i = 1; i < m; i++) {
            dp[i][0] = costs[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }
        int res = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            res = Math.min(res, dp[m - 1][j]);
        }
        return res;
    }
}
