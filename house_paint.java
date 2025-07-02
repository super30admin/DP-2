// We are using DP approach to solve the House Paint problem
// TC: O(n) --> we will be visiting every element once in a single pass while updating each value
// SC: O(1) --> we are not using any additional space but manipulating the given matrix

class Solution {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0){
            return 0;
        }
        int n = costs.length;
        for(int i=n-2;i>=0;i--){
            // For each value, we add the min value we can form from the next house 
            costs[i][0] = costs[i][0] + Math.min(costs[i+1][1], costs[i+1][2]);
            costs[i][1] = costs[i][1] + Math.min(costs[i+1][0], costs[i+1][2]);
            costs[i][2] = costs[i][2] + Math.min(costs[i+1][0], costs[i+1][1]);
        }
        // Return the minimum value from the top-most row 
        // which has already been updated with the minimum values from bottom rows
        return Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2]));
    }
}
