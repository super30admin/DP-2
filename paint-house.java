class Solution {
    public int minCost(int[][] costs) {
        
        // Time Complexity : O(n)
        // Space Complexity : O(1)
    
        for (int i = costs.length-2; i>=0; i--) {
            //color 1
            costs[i][0] += Math.min(costs[i+1][1], costs[i+1][2]);
            // color 2
            costs[i][1] += Math.min(costs[i+1][0], costs[i+1][2]);
            // color 3
            costs[i][2] += Math.min(costs[i+1][1], costs[i+1][0]);
        }
        
        return Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2]));
    }
}