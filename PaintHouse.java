// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : No, this is a premium question
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// 1: We maintain a dp table for this approach that we have optimized to use only three values
// 2: The prev pointer is at dp0, current is at dp1 and next at dp2
// 3: Keeping the last row constant, we calculate the minimum cost for each color of house and then return the minimum of the three
class PaintHouse{
    public int minCost(int[][] costs){
        int n = costs.length;
        // keeping last row constant
        int dp0 = costs[n-1][0];
        int dp1 = costs[n-1][1];
        int dp2 = costs[n-1][2];

        for(int i = 1; i<n; i++){
            int temp0 = dp0;
            int temp1 = dp1;
            dp0 = costs[i][0] + Math.min(dp1, dp2);
            dp1 = costs[i][1] + Math.min(temp1, dp2);
            dp2 = costs[i][2] + Math.min(temp0, temp1);
        }

        return Math.min(dp0, Math.min(dp1, dp2));
    }
}
