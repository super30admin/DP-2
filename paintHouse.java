// Time Complexity : O(nm)
// Space Complexity : O(nm)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int minCost(int[][] costs){
        if(costs == null || costs.length == 0){
            return 0;
        }
        int rows = costs.length;
        int cols= costs[0].length;
        
        int[][] dp = new int[cols][rows];
        
        for(int j = 0;j < m;j++){
            dp[0][j] = costs[0][j];
        }
        for(int i = 1; i < n; i++){
            for(int j = 0; j < m; j++) {
                if(j == 0){
                    dp[i][j] = costs[i][j] + Math.min(dp[i-1][1], dp[i-1][2]);
                }else if(j == 1){
                    dp[i][j] = costs[i][j] + Math.min(dp[i-1][0], dp[i-1][2]);
                }else{
                    dp[i][j] = costs[i][j] + Math.min(dp[i-1][0], dp[i-1][1]);
                }
            }
        }
        return Math.min(Math.min(dp[n-1][0], dp[n-1][1]), dp[n-1][2]);
    }
}