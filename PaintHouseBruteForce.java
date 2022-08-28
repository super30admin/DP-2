// Brute Force
// Time complexity 2^n
// Approach: This is an exhaustive approach we are taking to find minimum cost in every scenario using recursion

class Solution {
    public int minCost(int[][] costs) {
        int redCost = minCostHelper(costs, 0, 0, 0);
        int blueCost = minCostHelper(costs, 1, 0, 0);
        int greenCost = minCostHelper(costs, 2, 0, 0);
        
        return Math.min(redCost, Math.min(blueCost, greenCost));
    }
    
    private int minCostHelper(int[][] costs, int color, int idx, int minAmtSoFar) {
        // base
        if (idx == costs.length) {
            return minAmtSoFar;
        }
        
        // logic
        if (color == 0) {
            return Math.min(minCostHelper(costs, 1, idx + 1, minAmtSoFar + costs[idx][color]),
                           minCostHelper(costs, 2, idx + 1, minAmtSoFar + costs[idx][color]));
        }
        else if (color == 1) {
            return Math.min(minCostHelper(costs, 0, idx + 1, minAmtSoFar + costs[idx][color]),
                           minCostHelper(costs, 2, idx + 1, minAmtSoFar + costs[idx][color]));
        }
        return Math.min(minCostHelper(costs, 0, idx + 1, minAmtSoFar + costs[idx][color]),
                           minCostHelper(costs, 1, idx + 1, minAmtSoFar + costs[idx][color]));
    }
}