//Time Complexity = O(n)
//Space Complexity = O(1)

class Solution {
    public int minCost(int[][] costs) {
        int n = costs.length;
        for(int i = n-2; i>=0;i--){
            costs[i][0] = costs[i][0] + Math.min(costs[i+1][1], costs[i+1][2]);
            costs[i][1] = costs[i][0] + Math.min(costs[i+1][1], costs[i+1][2]);
            costs[i][2] = costs[i][0] + Math.min(costs[i+1][1], costs[i+1][2]);
        }
        return Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2]));
    }
}