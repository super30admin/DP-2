// Time Complexity : O(N) where N is number of rows
// Space Complexity : O(N)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :

public class Solution {
    /**
     * @param costs: n x 3 cost matrix
     * @return: An integer, the minimum cost to paint all houses
     */
    public int minCost(int[][] costs) {
        // write your code here
        if(costs==null || costs.length == 0) return 0;

        int n = costs.length;
        int[][] = new int[n][3];

        for(int j=0;j<2;j++){
            dp[n-1][j] = costs[n-1][j];
        }

        for(int i = n-2;i>=0; i--){
            dp[i][0] = costs[i][0]+Math.min(dp[i+1][1], dp[i+1][2]);
            dp[i][1] = costs[i][1]+Math.min(dp[i+1][0], dp[i+1][2]);
            dp[i][2] = costs[i][2]+Math.min(dp[i+1][0], dp[i+1][1]);
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i<3; i++){
            min = Math.min(min, dp[0][i]);
        }

        return min;
    }
}