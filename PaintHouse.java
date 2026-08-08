// Approach - Recursion can be used to pursue exhaustive path, but since this problem has repeated sub problems
// we could use Dynamic programming.
// Time Complexity  - O(m)
// Space Complexity - O(m)
class PaintHouse {
    public int minCost(int[][] costs)
    {
        //Validate the inputs
        if(costs == null || costs.length == 0){
            return 0;
        }

        int  m = costs.length;
        int[][] dp = new int[m][3];

        // Fill the last row
        dp[m-1][0] = costs[m-1][0];
        dp[m-1][1] = costs[m-1][1];
        dp[m-1][2] = costs[m-1][2];

        // Calculate the upper rows (take minimum), based on choice and values from the subproblems of earlier row.
        for(int i=m-2; i>=0; i--){
            dp[i][0] = costs[i][0] + Math.min(dp[i+1][1], dp[i+1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i+1][0], dp[i+1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i+1][0], dp[i+1][1]);
        }

        // Return minimum of the first row of costs array
        return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
    }
}