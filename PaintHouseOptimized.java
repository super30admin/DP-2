// Time complexity: O(n) where n is the number of houses
// Space complexity: O(1). This can be further optimized to a O(1). just 3 variables
// Approach: Dynamic programming. Similar to coin change pattern where we need a 2D array to perform the dynamic programming

class Solution {
    public int minCost(int[][] costs) {
        int costR = costs[costs.length-1][0];
        int costB = costs[costs.length-1][1];
        int costG = costs[costs.length-1][2];
        
        for (int i = costs.length - 2; i >= 0; i--) {
            int tempR = costR;
            int tempB = costB;
            costR = costs[i][0] + Math.min(costB, costG);
            costB = costs[i][1] + Math.min(tempR, costG);
            costG = costs[i][2] + Math.min(tempR, tempB);
        }
        
        return Math.min(costR, Math.min(costB, costG));
    }
}