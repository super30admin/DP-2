// Time Complexity : O(n*m)
// Space Complexity : O(n*m)
// Did this code successfully run on Leetcode : no, premium locked on leetcode
// Any problem you faced while coding this : 


class HousePaint {
    public int minCost(int[][] costs) {

        int rows = costs.length;
        int cols = costs[0].length;

        // Create a dp 2d array so as to not manipulate the input data
        int[][] dp = new int[rows][cols];

        //Fill the first row
        for(int i=0 ; i<cols; i++) {
            dp[0][i] = costs[0][i];
        }

        // Current cell value will be (current cell cost + minimum of painting non adjacent houses in the above row)
        for(int i=1; i<rows; i++) {
            dp[i][0] = costs[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
        }

        // Return minimum from the last row
        return Math.min(dp[rows-1][0], Math.min(dp[rows-1][1], dp[rows-1][2]));

    }    
}