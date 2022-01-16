// Time Complexity : O(n) n--> No. of houses
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int minCost(int[][] costs) {
        
        if(costs == null || costs.length == 0) return 0; //null check
        
        for(int i = costs.length - 2; i >= 0; i--){ //iterating through 2nd last row of the matrix
            //conditions for each color to choose min. cost and different color
        costs[i][0] += Math.min(costs[i + 1][1], costs[i + 1][2]); 
        costs[i][1] += Math.min(costs[i + 1][0], costs[i + 1][2]);
        costs[i][2] += Math.min(costs[i + 1][0], costs[i + 1][1]); 
            
    }
        return Math.min(costs[0][0], Math.min(costs[0][1],costs[0][2]));
    }
}