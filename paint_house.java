// Time Complexity : O(n)
// Space complexity : O(1)
class Solution {
    public int minCost(int[][] costs) {
        
        // Initialise min as min cost of the all three colors for the first house.
        int minval = Math.min(costs[0][0], Math.min(costs[0][1] , costs[0][2]));
        
        for (int i = 1; i < costs.length ; i++){
            
            
            // Consider if the one color is picked for that house, the previous house must have different colors. 
            // Taken case for that house + not taken case of other colors in the previous row (previous house)
            costs[i][0] = costs[i][0] + Math.min(costs[i-1][1], costs[i-1][2]);
            costs[i][1] = costs[i][1] + Math.min(costs[i-1][0], costs[i-1][2]);
            costs[i][2] = costs[i][2] + Math.min(costs[i-1][0], costs[i-1][1]);
            
            minval = Math.min(costs[i][0] , Math.min(costs[i][1] , costs[i][2]));
            
        }
        return minval;
    }
}