// Time Complexity : O(m*n)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach

class Solution {
    public int minCost(int[][] costs) {
        
        if (costs.length == 0) return 0;   

        int r = costs.length;
        int c = costs[0].length;
        
        for (int i = 1; i < r; i++) {
            
            // Total cost of painting the nth house red.
            costs[i][0] += Math.min(costs[i - 1][1], costs[i - 1][2]);
            
            // Total cost of painting the nth house green.
            costs[i][1] += Math.min(costs[i - 1][0], costs[i - 1][2]);
            
            // Total cost of painting the nth house blue.
            costs[i][2] += Math.min(costs[i - 1][0], costs[i - 1][1]);
        }

        

        //return min from last row 
        return Math.min(Math.min(costs[r-1][0], costs[r-1][1]), costs[r-1][2]);
    }
}
