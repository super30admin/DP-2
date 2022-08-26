// ## Problem1(https://leetcode.com/problems/paint-house/)

// time: O(n)
// space: O(n)
class Solution {
    /**
     * @param costs: n x 3 cost matrix
     * @return: An integer, the minimum cost to paint all houses
     */
    public int minCost(int[][] costs) {
        // write your code here
        int n = costs.length;
        int[][] dp = new int[n][3];
        for (int j = 0; j < 3; j++) {
            dp[n-1][j] = costs[n-1][j];
        }
        for (int i = n-2; i > 0; i--) {
            dp[i][0] = costs[i][0] + Math.min(dp[i+1][1], dp[i+1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i+1][0], dp[i+1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i+1][1], dp[i+1][0]);
        }
        return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
    }
}