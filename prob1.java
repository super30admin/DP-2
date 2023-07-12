// Time Complexity : O(h)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes


   class Solution {
    public int minCost(int[][] costs) {
        int h = costs.length;
        if (costs==null)
        {
            return 0;
        }
        for (int i=1; i<h; i++)
        {
            costs[i][0] = Math.min(costs[i-1][1]+costs[i][0], costs[i-1][2]+costs[i][0]);
            costs[i][1] = Math.min(costs[i-1][0]+costs[i][1], costs[i-1][2]+costs[i][1]);
            costs[i][2] = Math.min(costs[i-1][1]+costs[i][2], costs[i-1][0]+costs[i][2]);
        }

        return Math.min(Math.min(costs[h-1][0],costs[h-1][1]),costs[h-1][2]);

    }
}