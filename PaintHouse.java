// Time complexity: O(n) where n is the number of houses
// Space complexity: O(n). This can be further optimized to a O(1). just 3 variables
// Approach: Dynamic programming. Similar to coin change pattern where we need a 2D array to perform the dynamic programming

class Solution {
    public int minCost(int[][] costs) {
        int[][] dp = new int[costs.length][3];
        
        dp[costs.length-1][0] = costs[costs.length-1][0];
        dp[costs.length-1][1] = costs[costs.length-1][1];
        dp[costs.length-1][2] = costs[costs.length-1][2];
        
        for (int i = costs.length - 2; i >= 0; i--) {
            for (int j = 0; j < 3; j++) {
                dp[i][0] = costs[i][0] + Math.min(dp[i+1][1], dp[i+1][2]);
                dp[i][1] = costs[i][1] + Math.min(dp[i+1][0], dp[i+1][2]);
                dp[i][2] = costs[i][2] + Math.min(dp[i+1][0], dp[i+1][1]);
            }
        }
        
        return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
    }
}