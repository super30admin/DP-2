//Time Complexity - O(n)


public class PaintHouse {
    public static void main(String[] args) {
        int[][] costs = { { 17, 2, 17 }, { 16, 16, 5 }, { 14, 3, 19 } };
        System.out.println(minCost(costs));
    }

    public static int minCost(int[][] costs) {
        int n = costs.length;
        int[][] dp = new int[n][3];

        // Matrix Filling - Fill the same costs as the last row of input
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];

        // Fill the matrix from bottom up.
        for (int i = 1; i < n; i++) {
            dp[i][0] = costs[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }

        return Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));
    }

}
