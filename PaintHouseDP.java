// Time Complexity : O(N*3) = O(N)
// Space Complexity : O(N*3) = O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
public class Solution {
    /**
     * @param costs: n x 3 cost matrix
     * @return: An integer, the minimum cost to paint all houses
     */
    public int minCost(int[][] costs) {
        // base case
        if (costs == null || costs.length == 0) return 0;

        // dp array
        int[][] dp = new int[n][3];

        for (int j=0; j<3; j++) {
            dp[n-1][j] = costs[n-1][j];
        }

        for (int i=n-2; i>=0; i--) {
            dp[i][0] = costs[i][0] + Math.min(dp[i+1][1], dp[i+1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i+1][0], dp[i+1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i+1][0], dp[i+1][1]);
        }

        int min = Integer.MAX_VALUE;
        for (int i=0; i < 3; i++) {
            if (dp[0][i] <= min) min = dp[0][i];
        }

        // red =0, green = 1, blue=2
        int caseR=helper(costs, 0, 0, 0);
        int caseG=helper(costs, 0, 1, 0);
        int caseB=helper(costs, 0, 2, 0);

        return Math.min(caseR, Math.min(caseG, caseB));
    }
}
//-----------------------------------------------------------------------------------------------
// Brute force solution
//public class Solution {
//    /**
//     * @param costs: n x 3 cost matrix
//     * @return: An integer, the minimum cost to paint all houses
//     */
//    public int minCost(int[][] costs) {
//        // write your code here
//
//        // base case
//        if (costs == null || costs.length == 0) return 0;
//
//        // red =0, green = 1, blue=2
//        int caseR=helper(costs, 0, 0, 0);
//        int caseG=helper(costs, 0, 1, 0);
//        int caseB=helper(costs, 0, 2, 0);
//
//        return Math.min(caseR, Math.min(caseG, caseB));
//    }
//
//    private int helper (int[][] costs, int index, int color, int amount) {
//        // base
//        if (index == costs.length) return amount;
//
//        //if color red
//        if (color == 0) {
//            return Math.min(helper(costs, index+1, 1, amount + costs[index][0]), helper(costs, index+1,2, amount + costs[index][0]));
//        }
//        // color green
//        if (color == 1) {
//            return Math.min(helper(costs, index+1, 0, amount + costs[index][1]), helper(costs, index+1, 2, amount + costs[index][1]));
//        }
//        // color blue
//        if (color == 2) {
//            return Math.min(helper(costs, index+1, 0, amount + costs[index][2]), helper(costs, index+1, 1, amount + costs[index][2]));
//        }
//        return -1; // this statement will never run
//    }
//}