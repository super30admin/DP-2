// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
    //As I was not mutating the original costs array, I created a new DP array 
    //and missed filling the last row of DP array which would be the exact same as the last row of the costs array.


// Your code here along with comments explaining your approach

class Solution {
    public int minCost(int[][] costs) {
        
        //one approach is to modify the original matrix which would result in space complexity with O(1)
        //second approach is to create a DP 2D array, demonstrated in the below approach.

        //base case
        if(costs == null || costs.length == 0){
            return 0;
        }
        int n = costs.length;

        int[][] dp = new int[n][3];
        //fill the last row as base case
        dp[n - 1][0] = costs[n-1][0];
        dp[n - 1][1] = costs[n-1][1];
        dp[n - 1][2] = costs[n-1][2];

        //iterate through a row above last row and work your way up
        for(int i = n - 2; i >= 0; i--){
            dp[i][0] = costs[i][0] + Math.min(dp[i+1][1], dp[i+1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i+1][0], dp[i+1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i+1][1], dp[i+1][0]);
        }
        
        return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));

    }
}