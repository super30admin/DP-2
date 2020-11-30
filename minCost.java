// Time Complexity : O(N)
// Space Complexity :O(N) as Paints
// Did this code successfully run on Leetcode : 
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution{
    public int minCost(int[][] costs){
        if(costs == null || costs.length == 0){
            return 0;
        }
        int n = costs.length;
        for(int i = 0; i < n; i++){
            //Add the costs of the rows of the matrix
            //Taking mins and summing it up and then considering min from those
            costs[i][0] = costs[i][0] + Math.min(costs[i-1][1], costs[i-1][2]);
            costs[i][1] = costs[i][0] + Math.min(costs[i-1][0], costs[i-1][2]);
            costs[i][2] = costs[i][0] + Math.min(costs[i-1][0], costs[i-1][1]);
        }
        return Math.min(Math.min(costs[n-1][0], costs[n-1][1]), costs[n-1][2]);
    }
}