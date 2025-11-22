// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :No
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
//Keep a DP array of size 3 to store the minimum cost to paint the previous house in each color.
// For each house, update each color’s cost by adding its paint cost to the minimum of the other two colors from the previous house.
// After processing all houses, return the minimum value among the three colors, which gives the overall minimum painting cost.

class Solution {
    public int minCost(int[][] costs) {
        int n = costs.length;
        if( n==0){
            return 0;
        }
        int[] dp = new int[3];
        dp[0] = costs[0][0];
        dp[1] = costs[0][1];
        dp[2] = costs[0][2];

        for( int i =1; i < n; i++){
            int temp = dp[0];
            dp[0] = costs[i][0] + Math.min(dp[1],dp[2]);
            int temp_dp1 = dp[1];
            dp[1] = costs[i][1] + Math.min(temp,dp[2]);
            dp[2] = costs[i][2]+ Math.min(temp,temp_dp1);
        }
        return Math.min(dp[0], Math.min(dp[1],dp[2]));
    }}