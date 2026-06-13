// Time Complexity : O(n) n is number of houses
// Space complexity: O(n)
// Fill the  last house first followed by other houses using a dp table.
// cost of painting each house is calculated by cost of the house + min of cost of other colors of next house
// In the end, we just return the minimum cost among the three options for the first house.

class PaintHouse {
    public int minCost(int[][] costs) {
        int m = costs.length;
        // Number of columns is always 3 according to the constraints
        int[][] dp = new int[m][3];
        // fill the last row of dp with last row of costs
        dp[m-1][0] = costs[m-1][0];
        dp[m-1][1] = costs[m-1][1];
        dp[m-1][2] = costs[m-1][2];

        for(int i = m-2; i>= 0; i--) {
            // calculate the min cost of painting ith house for each color
            dp[i][0] = costs[i][0] + Math.min(dp[i+1][1], dp[i+1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i+1][0], dp[i+1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i+1][0], dp[i+1][1]);
        }

        return Math.min(dp[0][0] , Math.min(dp[0][1],dp[0][2]));
    }
}