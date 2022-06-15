// Time Complexity : O(mxn), where m is the number of the cost arrays , n is the length of each cost array
// Space Complexity : O(mxn), where m is the number of the cost arrays , n is the length of each cost array
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach

class Solution {
    public int minCost(int[][] costs) {
        int m = costs.length;
        int n = costs[0].length;
        int[][] dp = new int[m][n];
        
        for(int i = 0; i < n; i += 1) {
            dp[m-1][i] = costs[m-1][i];
        }
        
        for(int i = m - 2; i >= 0; i -= 1) {
            for (int j = 0; j < n; j += 1) {
                if(j == 0) dp[i][j] = costs[i][j] + Math.min(dp[i+1][1], dp[i+1][2]);
                else if(j == 2) dp[i][j] = costs[i][j] + Math.min(dp[i+1][0], dp[i+1][1]);
                else dp[i][j] = costs[i][j] + Math.min(dp[i+1][0], dp[i+1][2]);
            }
        }
        
        return Math.min(dp[0][1], Math.min(dp[0][0], dp[0][2]));
    }
}