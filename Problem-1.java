// Time Complexity : O(m)
// Space Complexity : O(m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
public class Solution {
    /**
     * @param costs: n x 3 cost matrix
     * @return: An integer, the minimum cost to paint all houses
     */
    public int minCost(int[][] costs) {
        // write your code here
        if(costs == null || costs.length == 0) return 0;

        int m = costs.length;

        int dp[][] = new int[m][3];
        for(int j=0;j<3;j++)
        {
            dp[m-1][j] = costs[m-1][j]; 
        }
        for(int i = m-2 ; i>=0 ;i--)
        {
            dp[i][0] = costs[i][0] + Math.min(dp[i+1][1],dp[i+1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i+1][0],dp[i+1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i+1][1],dp[i+1][0]);
        }
        int minimum = Integer.MAX_VALUE;
        for(int j=0;j<3;j++)
        {
            minimum = Math.min(dp[0][j],minimum);
        }
        return minimum;
    }
}