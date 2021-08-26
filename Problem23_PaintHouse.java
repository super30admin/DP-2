// Time Complexity : O(n), n -> length of the array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0)
            return 0;
        for(int i = 1; i < costs.length; i++) {
            costs[i][0] = costs[i][0] + Math.min(costs[i - 1][1], costs[i - 1][2]);
            costs[i][1] = costs[i][1] + Math.min(costs[i - 1][0], costs[i - 1][2]);
            costs[i][2] = costs[i][2] + Math.min(costs[i - 1][0], costs[i - 1][1]);
        }
        return Math.min(costs[costs.length - 1][0], Math.min(costs[costs.length - 1][1], costs[costs.length - 1][2]));
    }
}
