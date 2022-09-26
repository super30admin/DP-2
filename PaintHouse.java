// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

class Solution {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0)
            return 0;
        
        int[][] dp = new int[costs.length][3];
        
        for(int i = 0; i < 3; i++){
            dp[costs.length - 1][i] = costs[costs.length - 1][i];
        }
        
        for(int i = costs.length - 2; i >= 0; i--){
            dp[i][0] = costs[i][0] + Math.min(dp[i + 1][1], dp[i + 1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i + 1][0], dp[i + 1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i + 1][1], dp[i + 1][0]);
        }
        
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < 3; i++)
            min = Math.min(min, dp[0][i]);
        
        return min;
    }
}
