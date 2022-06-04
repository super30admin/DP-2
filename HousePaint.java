// Time Complexity : O(n)
// Space Complexity : O(nxm)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class HousePaint {

    // for non mutating matrix, time complexity is O(n), space complexity O(nxm)
    // where m is constant, so O(n)
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0)
            return 0;
        int n = costs.length;
        int m = costs[0].length;
        int[][] dp = new int[n + 1][m + 1];
        dp[n - 1][0] = costs[n - 1][0];
        dp[n - 1][1] = costs[n - 1][1];
        dp[n - 1][2] = costs[n - 1][2];
        for (int i = n - 2; i >= 0; i--) {
            dp[i][0] = costs[i][0] + Math.min(dp[i + 1][1], dp[i + 1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i + 1][2], dp[i + 1][0]);
            dp[i][2] = costs[i][2] + Math.min(dp[i + 1][0], dp[i + 1][1]);
        }
        return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
    }

    /*
     * //for mutating matrix, time complexity is O(n)
     * public int minCost(int[][] costs) {
     * if(costs == null || costs.length ==0) return 0;
     * int n = costs.length;
     * for(int i = n-2; i>=0; i--){
     * costs[i][0] += Math.min(costs[i+1][1],costs[i+1][2]);
     * costs[i][1] += Math.min(costs[i+1][2],costs[i+1][0]);
     * costs[i][2] += Math.min(costs[i+1][0],costs[i+1][1]);
     * }
     * return Math.min(costs[0][0], Math.min(costs[0][1],costs[0][2]));
     * }
     */

    /*
     * Time complexity is Exponential
     * public int minCost(int[][] costs) {
     * if(costs == null || costs.length ==0) return 0;
     * int caseR = helper(costs, 0, 0, 0);
     * int caseB = helper(costs, 0, 1, 0);
     * int caseG = helper(costs, 0, 2, 0);
     * return Math.min(caseR, Math.min(caseB, caseG));
     * }
     * 
     * private int helper(int[][] costs, int r, int colour, int minCosts){
     * 
     * //base
     * if(r == costs.length) return minCosts;
     * 
     * //logic
     * if(colour==0){
     * return Math.min(helper(costs, r+1, 1, minCosts + costs[r][0]),
     * helper(costs, r+1, 2, minCosts + costs[r][0]));
     * }
     * if(colour==1){
     * return Math.min(helper(costs, r+1, 0, minCosts + costs[r][1]),
     * helper(costs, r+1, 2, minCosts + costs[r][1]));
     * }
     * if(colour==2){
     * return Math.min(helper(costs, r+1, 1, minCosts + costs[r][2]),
     * helper(costs, r+1, 0, minCosts + costs[r][2]));
     * }
     * return 234;
     * }
     */

}
