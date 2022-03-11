/**
 * Time complexity is O(n)
 * space complexity is O(1)
 */
class Solution {
    public int minCost(int[][] costs) {
        int len = costs.length;
        for(int i = len - 2; i >= 0; i--) {
            costs[i][0] = costs[i][0] + Math.min(costs[i+1][1], costs[i+1][2]);
            costs[i][1] = costs[i][1] + Math.min(costs[i+1][0], costs[i+1][2]);
            costs[i][2] = costs[i][2] + Math.min(costs[i+1][1], costs[i+1][0]);
        }
        return Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2]));
    }
}