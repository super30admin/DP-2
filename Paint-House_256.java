// Time Complexity : O(N) where N = number of houses, also its mentioned that number of colors is 3 (fixed) so i am not counting iteration over colors in time complexity
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//dp[i][j] = Min {dp[i-i][k1]  dp[i-i][k2] .... } where k!= j

class Solution {
    public int minCost(int[][] costs) {
        int result = Integer.MAX_VALUE;
        int[][] dp = new int[costs.length][costs[0].length];
        dp[0] = costs[0];
        for(int i=1; i<costs.length; i++) {
            for (int j=0; j<costs[0].length; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for(int k=0; k<costs[0].length; k++) {
                    if (j == k) continue;
                    dp[i][j] = Math.min(dp[i-1][k] + costs[i][j], dp[i][j]);
                }
            }
        }
        result = dp[costs.length-1][0];
        for (int i=0; i<costs[0].length; i++) {
            result = Math.min(dp[costs.length-1][i], result);
        }
        return result;

    }
}
