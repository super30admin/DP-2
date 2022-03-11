/**
 * Time complexity is O(n)
 * space complexity is O(n)
 */
class Solution {
    public int minCost(int[][] costs) {
        int len = costs.length;
        int[][] dp = new int[len][3];
        dp[len-1][0] = costs[len-1][0];
        dp[len-1][1] = costs[len-1][1];
        dp[len-1][2] = costs[len-1][2];
        
        for(int i = len - 2; i >= 0; i--) {
            dp[i][0] = costs[i][0] + Math.min(dp[i+1][1], dp[i+1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i+1][0], dp[i+1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i+1][1], dp[i+1][0]);
        }
        return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
    }
}