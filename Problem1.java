// Time Complexity : O(n * m), m = 3 => O(n)
// Space Complexity : O(m) => O(3) => O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {

    public int minCost(int[][] costs) {

        if(costs.length == 0) return 0;

        for(int i = 1; i < costs.length; i++) {

            // Current cost + min cost for previous selections
            costs[i][0] = Math.min(costs[i - 1][1], costs[i - 1][2]);
            costs[i][1] = Math.min(costs[i - 1][0], costs[i - 1][2]);
            costs[i][2] = Math.min(costs[i - 1][0], costs[i - 1][1]);
        }

        return Math.min(costs[costs.length - 1][0], Math.min(costs[costs.length][1], costs[costs.length][2]));
    }
}