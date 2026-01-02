class Solution {
    public int minCost(int[][] costs) {
        // // Solution 1 = 2D approach
        // // TC = O(3n) = O(n)
        // // SC = O(3n) = O(n)
        // int n = costs.length;
        // int[][] dp = new int[n][3];
        // int[][] bestPath = new int[n][3]; // not a requirement of this problem. Just
        // wanted to solve best path as well.

        // for(int j=0; j<3; j++) {
        // dp[0][j] = costs[0][j];
        // }
        // for(int i=1; i<n;i++) {
        // int sum = 0; // not a requirement of this problem. Just wanted to solve best
        // path as well.
        // //Red

        // if(dp[i-1][1] > dp[i-1][2]) {
        // sum = dp[i-1][2];
        // bestPath[i][0] = 2;
        // } else {
        // sum = dp[i-1][1];
        // bestPath[i][0] = 1;
        // }
        // dp[i][0] = costs[i][0]+ sum;

        // //Blue
        // if(dp[i-1][0] > dp[i-1][2]) {
        // sum = dp[i-1][2];
        // bestPath[i][1] = 2;
        // } else {
        // sum = dp[i-1][0];
        // bestPath[i][1] = 0;
        // }
        // dp[i][1] = costs[i][1]+ sum;

        // //Green
        // if(dp[i-1][1] > dp[i-1][0]) {
        // sum = dp[i-1][0];
        // bestPath[i][2] = 0;
        // } else {
        // sum = dp[i-1][1];
        // bestPath[i][2] = 1;
        // }
        // dp[i][2] = costs[i][2]+ sum;

        // }
        // // System.out.println("BesPath: " + Arrays.deepToString(bestPath));

        // return Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2]));

        // Solution 2 - 1D DP array
        int n = costs.length;
        int redIdx = costs[0][0];
        int blueIdx = costs[0][1];
        int greenIdx = costs[0][2];

        for (int i = 1; i < n; i++) {
            int tempRed = redIdx;
            // Red
            redIdx = costs[i][0] + Math.min(blueIdx, greenIdx);

            int tempBlue = blueIdx;
            // Blue
            blueIdx = costs[i][1] + Math.min(tempRed, greenIdx);

            // Green
            greenIdx = costs[i][2] + Math.min(tempRed, tempBlue);

        }

        return Math.min(redIdx, Math.min(blueIdx, greenIdx));

    }
}