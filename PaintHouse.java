// Time Complexity : o(mn)
// Space Complexity :0(mn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int minCost(int[][] costs) {
        
        if(costs==null || costs.length ==0) return 0;
        int n = costs.length;
        int[][] dp = new int[n][3];
        
        for(int i=0;i<3;i++){
            dp[n-1][i] = costs[n-1][i];
        }
        
        for(int j = n-2;j>=0;j--){
            
            dp[j][0] =costs[j][0] + Math.min(dp[j+1][1],dp[j+1][2]);
            dp[j][1] =costs[j][1] + Math.min(dp[j+1][0],dp[j+1][2]);
            dp[j][2] =costs[j][2] + Math.min(dp[j+1][0],dp[j+1][1]);
            
        }
        
        return Math.min(dp[0][0],Math.min(dp[0][1],dp[0][2]));
        
    }
}