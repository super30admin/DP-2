// Time Complexity :   O(2 * N) where N = number of houses
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int minCost(int[][] costs) {
        
        //This is the Paint house pattern in DP
        //As the input is 1 we will use 1D array
        int dp[] = new int[3];
        int n = costs.length;

        //instead of dp[] we can also use varR, varB, varG
        dp[0] = costs[n - 1][0];
        dp[1] = costs[n - 1][1];
        dp[2] = costs[n - 1][2];

        //we will start from bottom
        for(int i = n - 2; i >= 0; i--) {

            int tempRed = dp[0];
            dp[0] = costs[i][0] + Math.min(dp[1], dp[2]);

            int tempBlue = dp[1];
            dp[1] = costs[i][1] + Math.min(tempRed, dp[2]);

            dp[2] = costs[i][2] + Math.min(tempRed, tempBlue);
        }

        //the min cost of painting house with each color
        return Math.min(dp[0], Math.min(dp[1], dp[2]));
    }
}