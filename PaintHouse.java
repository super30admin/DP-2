/**
 * There are a row of n houses, each house can be painted with one of the three
 * colors: red, blue or green. The cost of painting each house with a certain
 * color is different. You have to paint all the houses such that no two
 * adjacent houses have the same color.
 * 
 * The idea is to use dynamic programming, we store the solutions to
 * subproblems. As we can see that we only need to look back for the previous
 * house, we can further optimize space to constant.
 * 
 * Space Complexity: O(n), n is the number of houses Time Complexity: O(n)
 * 
 * Leetcode Results: Runtime: 1 ms, faster than 66.06% of Java online
 * submissions for Paint House. Memory Usage: 39.6 MB, less than 94.12% of Java
 * online submissions for Paint House.
 */
class PaintHouse {
    /**
     * The cost of painting each house with a certain color is represented by a n
     * x 3 cost matrix. For example, costs[0][0] is the cost of painting house 0
     * with color red; costs[1][2] is the cost of painting house 1 with color green,
     * and so on... Find the minimum cost to paint all houses.
     * 
     * @param costs
     * @return
     */
    public int minCost(int[][] costs) {

        if (costs.length == 0) {
            return 0;
        }

        int[][] dp = new int[costs.length][3];
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];
        int i;
        for (i = 1; i < costs.length; i++) {
            dp[i][0] = costs[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i - 1][2], dp[i - 1][0]);
            dp[i][2] = costs[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }
        return Math.min(Math.min(dp[i - 1][0], dp[i - 1][1]), dp[i - 1][2]);
    }
}