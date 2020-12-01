class Solution {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0){
            return 0;
        }
        // dp[i][j] = minimum costs to paint ith house with jth color.
        int n = costs.length;
        for(int i=1;i<costs.length;i++){
            costs[i][0] = costs[i][0] + Math.min(costs[i-1][1],costs[i-1][2]);
            costs[i][1] = costs[i][1] + Math.min(costs[i-1][0],costs[i-1][2]);
            costs[i][2] = costs[i][2] + Math.min(costs[i-1][1],costs[i-1][0]);
        }
        return Math.min(costs[n-1][0],Math.min(costs[n-1][1],costs[n-1][2]));
    }
}