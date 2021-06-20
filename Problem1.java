// Time Complexity : O(n), (n*3) where n is no of rows
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0) {
            return 0;
        }

        // start from last 2nd row till first row
        // add from last 2nd + bottom row and so on
        for(int i = costs.length - 2; i >= 0; i--) {
            costs[i][0] = costs[i][0] + Math.min(costs[i+1][1], costs[i+1][2]);
            costs[i][1] = costs[i][1] + Math.min(costs[i+1][0], costs[i+1][2]);
            costs[i][2] = costs[i][2] + Math.min(costs[i+1][0], costs[i+1][1]);
        }

        // min from 1st row
        return Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2]));
    }
}