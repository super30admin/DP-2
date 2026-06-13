// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Needed to store old dp values before updating them.


class PaintHouse{
    public int minCost(int[][] costs) {
    
        int n = costs.length;

        // dp[0], dp[1], dp[2] store min cost if current house is painted
        // red, blue, or green respectively
        int dp [] = new int[3];

        // Start from the last house
        dp[0] = costs[n-1][0];
        dp[1] = costs[n-1][1];
        dp[2] = costs[n-1][2];

         // Move from second last house to first house
        for(int i = n-2; i >= 0; i++){
            int tempR = dp[0];
            dp[0] = costs[i][0] + Math.min(dp[1], dp[2]);
            int tempB = dp[1];
            dp[1] = costs[i][1] + Math.min(tempR, dp[2]);
            dp[2] = costs[i][2] + Math.min(tempR, tempB);
        }


        return Math.min(dp[0], Math.min(dp[2], dp[1]));
       
    
    }
}