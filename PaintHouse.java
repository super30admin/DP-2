// Time Complexity : O(n) // n is total number of houses
// Space Complexity : O(mxn) // here 3 color so O(n) else it is m x n : m colors choices with n houses to paint.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Learning DP. Able to solve after watching class recording twice. Needs help.

/*
    We are starting building bottom up tree by making new matrix.
    Calculate minimum at each row and column level. Go to all the way up. At end, minimum of all columns of first 3 rows is our minimum cost to paint house.

    It is good Dynamic program pattern to learn.
*/

public class PaintHouse {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0) {
            return -1;
        }
        int n = costs.length;
        int[][] dp = new int[n][3];

        dp[n-1][0] = costs[n-1][0];
        dp[n-1][1] = costs[n-1][1];
        dp[n-1][2] = costs[n-1][2];

        for(int i=n-2; i>=0; i--){
            dp[i][0] = costs[i][0] + Math.min(dp[i+1][1], dp[i+1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i+1][0], dp[i+1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i+1][0], dp[i+1][1]);
        }
        return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
    }

    public static void main(String args[]){
        PaintHouse ph = new PaintHouse();
        ph.minCost(new int[][]{{17,2,17},{16,16,5},{14,3,19}});
    }
}