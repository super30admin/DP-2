/**
Problem: Paint house leetcode 256
https://leetcode.com/problems/paint-house/

TC: O(m * n) where m = #rows and n = #cols
SC = O(2 *  m) = O(m)
*/
class Solution {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;
        if (costs[0] == null || costs[0].length == 0) return 0;
        
        int rows = costs.length;
        int cols = costs[0].length;
        int dp[][] = new int[2][cols];
        int minCost = Integer.MAX_VALUE;
        
        for (int j = 0; j < cols; ++j) {
            dp[0][j] = costs[0][j];
        }
        
        for (int i = 1; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (j == 0)
                    dp[i % 2][j] = Math.min(dp[(i-1) % 2][1], dp[(i-1) % 2][2]) + costs[i][j];
                else if (j == 1)
                    dp[i % 2][j] = Math.min(dp[(i-1) % 2][0], dp[(i-1) % 2][2]) + costs[i][j];
                else
                    dp[i % 2][j] = Math.min(dp[(i-1) % 2][0], dp[(i-1) % 2][1]) + costs[i][j];
            }
        }
        
        for (int j = 0; j < cols; ++j) {
            minCost = Math.min(minCost, dp[(rows-1) % 2][j]);
        }
        return minCost;
    }
}