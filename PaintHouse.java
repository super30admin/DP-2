public class PaintHouse {
    public static void main(String[] args) {
        int[][] costs = {
                { 17, 2, 17 },
                { 16, 16, 5 },
                { 14, 3, 19 }
        };
        // Red = 0, Green = 1, Blue = 2
        int red = helper(costs, 0, 0, 0);
        int green = helper(costs, 0, 1, 0);
        int blue = helper(costs, 0, 2, 0);

        int result = Math.min(red, Math.min(green, blue));
        System.out.println("Exhaustive Search Solution");
        System.out.println("Min Cost : " + result);

        System.out.println("DP Solution");
        int n = costs.length;
        int[][] dp = new int[n][3];
        for (int i = 0; i < 3; i++) {
            dp[n - 1][i] = costs[n - 1][i];
        }
        for (int i = n - 2; i >= 0; i--) {
            dp[i][0] = costs[i][0] + Math.min(dp[i + 1][1], dp[i + 1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i + 1][0], dp[i + 1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i + 1][0], dp[i + 1][1]);
        }
        int dpResult = Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
        System.out.println("DP Min Cost : " + dpResult);
    }

    private static int helper(int[][] costs, int row, int color, int cost) {
        if (row == costs.length) {
            return cost;
        }
        // Red
        if (color == 0) {
            return Math.min(helper(costs, row + 1, 1, cost + costs[row][0]),
                    helper(costs, row + 1, 2, cost + costs[row][0]));
        }
        // Green
        if (color == 1) {
            return Math.min(helper(costs, row + 1, 0, cost + costs[row][1]),
                    helper(costs, row + 1, 2, cost + costs[row][1]));
        }
        // Blue
        if (color == 2) {
            return Math.min(helper(costs, row + 1, 0, cost + costs[row][2]),
                    helper(costs, row + 1, 1, cost + costs[row][2]));
        }
        return 0;
    }
}
