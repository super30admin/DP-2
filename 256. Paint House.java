class Solution {
    // Time complexity: O(n)
    // Space complexity: O(1)
    public int minCost(int[][] costs) {
        // firstly, we need check the null cases
        if(costs == null || costs.length == 0)
            return 0;
        
        for(int i = costs.length - 2; i >= 0; i--){
            // total cost of painting the ith house with blue
            costs[i][2] = costs[i][2] + Math.min(costs[i + 1][0], costs[i + 1][1]);
            // total cost of painting the ith house with green
            costs[i][1] = costs[i][1] + Math.min(costs[i + 1][0], costs[i + 1][2]);
            // total cost of painting the ith house with red
            costs[i][0] = costs[i][0] + Math.min(costs[i + 1][1], costs[i + 1][2]);
        }
        return Math.min(costs[0][1], Math.min(costs[0][2], costs[0][0]));
    }
}