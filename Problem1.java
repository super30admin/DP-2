// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int minCost(int[][] costs) {
        // If nohouses
        if (costs==null|| costs.length==0) return 0;
        int n = costs.length;
        int[][]dp=new int[n][3];
        // Base casefirst house cost stays same
        dp[0][0] = costs[0][0]; //red
        dp[0][1] = costs[0][1]; //blue
        dp[0][2] = costs[0][2]; //green
        // Fill dp table
        for (int i = 1; i < n; i++) {
            //Dp[i] the number of ways to make amout i
            dp[i][0]=costs[i][0]+Math.min(dp[i-1][1],dp[i-1][2]);
            dp[i][1]=costs[i][1]+Math.min(dp[i-1][0],dp[i-1][2]);
            dp[i][2]=costs[i][2]+Math.min(dp[i-1][0],dp[i-1][1]);
        }
        // Minimum of last house
        return Math.min(dp[n - 1][0], 
               Math.min(dp[n - 1][1], dp[n - 1][2]));
    }
}
