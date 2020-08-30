
// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int minCost(int[][] costs) {
        
        //if cost matrix is empty, return 0
        if(costs.length == 0){
            return 0;
        }
        
        //we start updating the matrix at every level by putting the minimum possible cost if we start from index 1 as we can look at the previous house cost options. Follow this approach in a top down manner.
        for(int i = 1; i < costs.length; i++){
            //keep updating the minimum cost
            costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]);
            costs[i][1] += Math.min(costs[i-1][0], costs[i-1][2]);
            costs[i][2] += Math.min(costs[i-1][0], costs[i-1][1]);
        }
        
        //finally return the minimum value from the last row of the updated matrix which would give us the minimum cost to paint the three houses with no adjacent house being painted with the same color
        return Math.min(costs[costs.length - 1][0], Math.min(costs[costs.length - 1][1], costs[costs.length - 1][2]));
    }
}