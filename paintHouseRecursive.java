class Solution {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        
        int redCost = helper(costs, 0, 0, 0);
        int greenCost = helper(costs, 1, 0, 0);
        int blueCost = helper(costs, 2, 0, 0);
        return (Math.min(redCost, Math.min(greenCost, blueCost)));
    }
    
    private int helper(int costs[][], int color, int row, int totalCost) {
        //base
        if (row >= costs.length) {
            return totalCost;
        }
        
        // logic
        if (color == 0) {
            return Math.min(
                helper(costs, 1, row + 1, totalCost + costs[row][0]),
                helper(costs, 2, row + 1, totalCost + costs[row][0])
            );
        } else if (color == 1) {
            return Math.min(
                helper(costs, 0, row + 1, totalCost + costs[row][1]),
                helper(costs, 2, row + 1, totalCost + costs[row][1])
            );
        } else {
            return Math.min(
                helper(costs, 0, row + 1, totalCost + costs[row][2]),
                helper(costs, 1, row + 1, totalCost + costs[row][2])
            );
        }
    }
}