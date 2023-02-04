// Time Complexity : O(n * 3) = O(n), where n is number of houses
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/* We use dp here. We start from end of array and copy the last row of costs to dp array. Then we iterate and start storing values
   for each case where we decide to paint the current house as red, green or blue. We check Math.min(dp[i + 1][1], dp[i + 1][2]) for red
   and similarly for other colors. Eventually when done, we check the minimum of first row of dp array and return it. That is the min 
   cost.
*/

class Solution {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0)
            return -1;

        int n = costs.length;
        int m = costs[0].length;

        int[][] dp = new int[n][m];

        for(int j = 0; j < m; ++j) {
            dp[n - 1][j] = costs[n - 1][j];
        }

        for(int i = n - 2; i >= 0; --i) {
            dp[i][0] = costs[i][0] + Math.min(dp[i + 1][1], dp[i + 1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i + 1][0], dp[i + 1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i + 1][0], dp[i + 1][1]);
        }
        return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
    }
}