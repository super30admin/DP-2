// DP Approach
// Bottom Up Approach
// Check for min between the row just below it and add the min from other paint colours to the matrix index
// Fill the matrix and the topmost value will give you the min cost of painting.

// Time Complexity O(m) 
// Space Complexity O(1)
class Solution {
    public int minCost(int[][] costs) {
        for(int i=costs.length-2;i>=0;i--){
            costs[i][0] += Math.min(costs[i+1][1],costs[i+1][2]);
            costs[i][1] += Math.min(costs[i+1][0],costs[i+1][2]);  
            costs[i][2] += Math.min(costs[i+1][0],costs[i+1][1]);
        }
        return Math.min(costs[0][0],Math.min(costs[0][1],costs[0][2]));
    }
}