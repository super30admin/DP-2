// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/*
If we go bottom up, we feed the last row into our dp array and start looping from the row above and compute
by summation of cost to paint that cell's house and min cost required to paint with non adjacent colors
of the succeding row.This way, we cumulate the total sum in each row as we go up and finally choose the
minimum value from the intial row which represents the total cost.
 */

class Solution {
    public int minCost(int[][] costs) {
        int m = costs.length;
        int[][] dp = new int[m][3];

        for(int j = 0 ; j < 3 ; j++)
            dp[m - 1][j] = costs[m - 1][j];

        for(int i = m - 2 ; i >= 0 ; i--) {
            dp[i][0] = costs[i][0] + Math.min(dp[i + 1][1], dp[i + 1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i + 1][0], dp[i + 1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i + 1][0], dp[i + 1][1]);
        }
        return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
    }
}