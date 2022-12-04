// PAINT HOUSE

// Time Complexity : O(m), where m is the number of houses
// Space Complexity : O(m), where m is the number of houses
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -


// Your code here along with comments explaining your approach

class Solution {
    public int minCost(int[][] costs) {
        int m = costs.length; // Number of houses
        for(int i = m - 2; i >= 0; i--){ // Bottom-up DP, say 0 is red, 1 is blue and 2 is green
            costs[i][0] = costs[i][0] + Math.min(costs[i+1][1], costs[i+1][2]); // If the current house is being painted red, minimum between the cost of painting the house below with blue and green is added to the current cost
            costs[i][1] = costs[i][1] + Math.min(costs[i+1][0], costs[i+1][2]); // If the current house is being painted blue, minimum between the cost of painting the house below with green and red is added to the current cost
            costs[i][2] = costs[i][2] + Math.min(costs[i+1][1], costs[i+1][0]); // If the current house is being painted green, minimum between the cost of painting the house below with blue and red is added to the current cost
        }
        return Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2])); // Return minimum among the cost calculated for starting with red, green or blue paints
    }
}
