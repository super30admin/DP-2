/**
 * Leet Code : https://leetcode.com/problems/paint-house/submissions/1798030723/
 *
 * Approach:
 * This solution uses bottom-up dynamic programming (tabulation) to find the minimum cost to paint all houses such that
 * no two adjacent houses have the same color. Each house can be painted with one of three colors, and the cost for each
 * color is given. We maintain a DP table where dp[i][j] represents the minimum cost to paint up to house i with color j.
 *
 * - For the first house, the cost is simply the given cost for each color.
 * - For each subsequent house, for each color, we add the current cost to the minimum cost of painting the previous house
 *   with a different color (since adjacent houses cannot have the same color).
 * - The answer is the minimum value among the three colors for the last house.
 *
 * Time Complexity: O(n), where n is the number of houses (since we process each house and color in constant time).
 * Space Complexity: O(n) for the 2D DP array, or O(1) for the optimized version using a 1D array.
 */
public class PaintHouseDP {

    /**
     * Standard DP approach using a 2D array.
     * dp[i][j] = min cost to paint up to house i, with color j.
     */
    public int minCost(int[][] costs) {
        int n = costs.length;
        int[][] dp = new int[n][3];
        // Initialize the first house's costs
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];
        // Fill the DP table
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = costs[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }
        return Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));
    }

    /**
     * Optimized DP approach using a 1D array (since only previous row is needed).
     */
    public int minCost2(int[][] costs) {
        int[] dp = new int[3];
        // Initialize the first house's costs
        dp[0] = costs[0][0];
        dp[1] = costs[0][1];
        dp[2] = costs[0][2];
        for (int i = 1; i < costs.length; i++) {
            int colorR = dp[0];
            int colorB = dp[1];
            int colorG = dp[2];
            dp[0] = costs[i][0] + Math.min(colorB, colorG);
            dp[1] = costs[i][1] + Math.min(colorR, colorG);
            dp[2] = costs[i][2] + Math.min(colorR, colorB);
        }
        return Math.min(dp[0], Math.min(dp[1], dp[2]));
    }

    public static void main(String[] args) {
        System.out.println(new PaintHouseDP().minCost2(new int[][]{{17, 2, 17}, {16, 16, 5}, {14, 3, 19}}));
        System.out.println(new PaintHouseDP().minCost2(new int[][]{{17, 2, 17}}));
    }
}
