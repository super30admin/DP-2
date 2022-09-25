// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class PaintHouseSolution {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0) {
            return 0;
        }
        int n = costs.length;
        int[][] dp = new int[n][3];
        
        for(int j = 0; j < 3; j += 1) {
            dp[n - 1][j] = costs[n - 1][j]; 
        }

        for(int i = n - 2; i >= 0; i -= 1) {
            dp[i][0] = costs[i][0] + Math.min(dp[i + 1][1], dp[i + 1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i + 1][0], dp[i + 1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i + 1][1], dp[i + 1][0]);
        }
        int min = Integer.MAX_VALUE;

        for(int j = 0; j < 3; j += 1) {
            min = Math.min(min, dp[0][j]);
        }

        return min;
    }
}
