// Time Complexity : O(N)
// Space Complexity : O(1) we are editing given matrix
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this: Understood the problem
// Summary: go from bottom row and add minimum possible value until you get to top, then return min from top row


class Solution {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length ==0){
            return 0;
        }
        for(int i = costs.length - 2; i>=0; i--){
            costs[i][2] = costs[i][2] + Math.min(costs[i+1][0], costs[i+1][1]);
            costs[i][1] = costs[i][1] + Math.min(costs[i+1][0], costs[i+1][2]);
            costs[i][0] = costs[i][0] + Math.min(costs[i+1][2], costs[i+1][1]);
        }
        
        return Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2]));
        
    }
    
}
