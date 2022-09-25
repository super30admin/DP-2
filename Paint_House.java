public class Solution {
    /**
     * @param costs: n x 3 cost matrix
     * @return: An integer, the minimum cost to paint all houses
     * TC : O(costs.length)
     * SC : O(1)
     */
    public int minCost(int[][] costs) {
        
        if (costs == null || costs.length == 0) return 0;
        
        int result = Integer.MAX_VALUE;
        int n = costs.length;
        for(int i = n - 2; i >= 0; i--) {
          costs[i][2] = costs[i][2] + Math.min(costs[i+1][0],costs[i+1][1]);
          costs[i][1] = costs[i][1] + Math.min(costs[i+1][0],costs[i+1][2]);
          costs[i][0] = costs[i][0] + Math.min(costs[i+1][1],costs[i+1][2]);
        }
            
        result = Math.min(Math.min(costs[0][0],costs[0][1]), costs[0][2]);
            
        return result;    
        }
}
