/**
Problem: Paint Houses

Time Complexity: O(n), where n is the number of houses
Space Complexity: O(1) as we don't use any additional data structure. We're modifying the cost matrix in place.
Did this code successfully run on Leetcode : Yes

Approach : Dynammic Programming.
1. We assume that one house is colored with a particular color first.
2. So while coloring the next, we make sure it's not the previous color.
3. In order to do this, the cost of coloring the present house with your choice of color is added 
to the minimum of painting the previous house with any color other than this is added.
4. In the end, we return the minimum of the last row(as this includes cost of painting all the houses).
*/

class Solution {
    public int minCost(int[][] costs) {
        if(costs.length == 0 || costs == null) 
            return 0;
        for(int i = 1; i<costs.length; i++) {
            //if the house is colored red
            costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]);
            
            //if the house is colored green
            costs[i][1] += Math.min(costs[i-1][0], costs[i-1][2]);
            
             //if the house is colored blue
            costs[i][2] += Math.min(costs[i-1][0], costs[i-1][1]);
        }
        return Math.min(Math.min(costs[costs.length-1][0], costs[costs.length-1][1]), costs[costs.length-1][2]);
    }
}