// Time Complexity : O(3*n) ~ O(n)
// Space Complexity : O(3*n) ~ O(n)
public class PaintHouse {
    public static void main(String[] args) {
        int[][] costs = { { 17, 2, 17 }, { 16, 16, 5 }, { 14, 3, 19 } };
        int result = minCost(costs);
        System.out.println("Min Cost to paint all houses :: " + result);
    }

    /**
     * 
     * @param costs
     * @return the minimum cost to paint all houses
     */
    private static int minCost(int[][] costs) {
        if (costs == null || costs.length == 0)
            return 0;
        int n = costs.length;
        int[][] dp = new int[n][3];
        dp[n - 1][0] = costs[n - 1][0];
        dp[n - 1][1] = costs[n - 1][1];
        dp[n - 1][2] = costs[n - 1][2];
        for (int i = n - 2; i >= 0; i--) {
            dp[i][0] = costs[i][0] + Math.min(dp[i + 1][1], dp[i + 1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i + 1][0], dp[i + 1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i + 1][0], dp[i + 1][1]);
        }
        return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
    }

}
