class Solution {

    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0)
            return 0;

        // Dynamic Programmming

        int n = costs.length;

        int[] dp = new int[3];
        dp[0] = costs[n - 1][0];
        dp[1] = costs[n - 1][1];
        dp[2] = costs[n - 1][2];

        for (int i = n - 2; i >= 0; i--) {
            int tempR = dp[0];
            dp[0] = Math.min(dp[1], dp[2]) + costs[i][0];
            int tempB = dp[1];
            dp[1] = Math.min(tempR, dp[2]) + costs[i][1];
            dp[2] = Math.min(tempB, tempR) + costs[i][2];
        }

        return Math.min(dp[0], Math.min(dp[1], dp[2]));

        /*
         * Exhaustive approach
         * int costR = helper(costs, 0, 0, 0);
         * int costB = helper(costs, 1, 0, 0);
         * int costG = helper(costs, 2, 0, 0);
         * 
         * return Math.min(costR, Math.min(costG, costB));
         * 
         */
    }
    /*
     * Exhaustive approach where we form the value table for all the possible paths.
     * private int helper(int[][] costs, int color, int i, int min) {
     * // base
     * if (i == costs.length) {
     * return min;
     * }
     * 
     * if (color == 0) {
     * return Math.min(helper(costs, 1, i + 1, min + costs[i][0]),
     * helper(costs, 2, i + 1, min + costs[i][0]));
     * }
     * 
     * if (color == 1) {
     * return Math.min(helper(costs, 0, i + 1, min + costs[i][1]),
     * helper(costs, 2, i + 1, min + costs[i][1]));
     * }
     * 
     * if (color == 2) {
     * return Math.min(helper(costs, 1, i + 1, min + costs[i][2]),
     * helper(costs, 0, i + 1, min + costs[i][2]));
     * }
     * return 1;
     * }
     */
}