// Time Complexity : O(houses * colors)
// Space Complexity : O(houses * colors)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int minCost(int[][] costs) {
        int n = costs.length; // length of houses
        int[][] dp = new int[n][3]; // 3 colors

        // lets do a bottoms up approach so keep bottom values same
        dp[n-1][0] = costs[n-1][0]; // red cost
        dp[n-1][1] = costs[n-1][1]; // blue cost
        dp[n-1][2] = costs[n-1][2]; // green cost

        for(int i = n-2; i >= 0; i--){
            // iterate from bottom - 1, as we have just copied last row values as is
            dp[i][0] = costs[i][0] + Math.min(dp[i+1][1], dp[i+1][2]);  //red
            dp[i][1] = costs[i][1] + Math.min(dp[i+1][0], dp[i+1][2]); // blue
            dp[i][2] = costs[i][2] + Math.min(dp[i+1][0], dp[i+1][1]); // green
        }

        // return minimum of the 3 from first row
        return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
    }

}