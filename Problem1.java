// Time Complexity : O(N) ~ where N is the number of houses to be colored
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
Initially took a 1-D array of 3 size where initialzed with the first row of costs.
Then in each iteration added the current row,col value + the minimum of previous row. Eg - if 0, then previous row 1 and 2 columns.
Held the previous row red and blue in temp variables since the value will be updated in each iteration
*/


public class Problem1 {
    public int minCost(int[][] costs) {
        if(costs.length == 0) {
            return 0;
        }

        int m = costs.length;
        int[] dp = new int[3];

        dp[0] = costs[0][0];
        dp[1] = costs[0][1];
        dp[2] = costs[0][2];
        for(int i = 1;i<m;i++) {
            int tempR = dp[0];
            dp[0] = costs[i][0] + Math.min(dp[1], dp[2]);
            int tempB = dp[1];
            dp[1] = costs[i][1] + Math.min(tempR, dp[2]);
            dp[2] = costs[i][2] + Math.min(tempR, tempB);
        }

        return Math.min(dp[0], Math.min(dp[1], dp[2]));
    }

    public static void main(String[] args) {
        Problem1 obj = new Problem1();
        System.out.println(obj.minCost(new int[][]{{17,2,17},{16,16,5},{14,3,19}}));
    }
}
