class Solution {

    // TC: O(n) SC: O(m)
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        int n = costs.length;
        int[] dp = new int[3];
        // int colorRed = 0, colorBlue = 0, colorGreen = 0;
        if (n == 1) {
            return Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2]));
        }
        if (n >= 2) {
            int row = n - 2;
            // Intialize dp aaray with cost of painting last house with red color
            dp[0] = costs[row + 1][0];
            // Intialize dp aaray with cost of painting last house with blue color
            dp[1] = costs[row + 1][1];
            // Intialize dp aaray with cost of painting last house with green color
            dp[2] = costs[row + 1][2];

            while (row >= 0) {
                int colorRed = costs[row][0] + Math.min(dp[1], dp[2]);
                int colorBlue = costs[row][1] + Math.min(dp[0], dp[2]);
                int colorGreen = costs[row][2] + Math.min(dp[0], dp[1]);
                dp[0] = colorRed;
                dp[1] = colorBlue;
                dp[2] = colorGreen;
                row--;
            }
        }
        return Math.min(dp[0], Math.min(dp[1], dp[2]));
    }

    // TC: O(coins.length*amount) SC:O(coins.length*amount)
    public int change(int amount, int[] coins) {
        if (coins == null || coins.length == 0) {
            return 0;
        }
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int i = 0; i < coins.length + 1; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < coins.length + 1; i++) {
            for (int j = 1; j < amount + 1; j++) {
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }
        return dp[coins.length][amount];
    }
}