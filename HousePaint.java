// DP bottom up approach
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class Solution {
    public int minCost(int[][] costs) {
        if(costs == null || costs ==0) return 0;
        int[][] dp = new int[n][3];
        dp[n-1][0] =  
        int n = costs.length;
        for(int i = n-2;i>=0;i--){
            dp[i][0] += Math.min(dp[i+1][1], dp[i+1][2]);
            dp[i][1] += Math.min(dp[i+1][0], dp[i+1][2]);
            dp[i][2] += Math.min(dp[i+1][0], dp[i+1][1]);
        }
        return Math.min(dp[0][0], Math.min(dp[0][1],dp[0][2]));
    }
}
