// Time Complexity: O(n) where n is the number of rows in the matrix.
// Space complexity: O(1).

class PaintHouse {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0) return 0;
        for(int i = costs.length - 2; i >= 0; i--) {
            costs[i][0] = costs[i][0] + Math.min(costs[i + 1][1], costs[i + 1][2])
            costs[i][1] = costs[i][1] + Math.min(costs[i + 1][0], costs[i + 1][2])
            costs[i][2] = costs[i][2] + Math.min(costs[i + 1][0], costs[i + 1][1])
        }
        return Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2]));
    }

    // // Exhaustive approach
    // public int minCost(int[][] costs) {
    //     if(costs == null || costs.length == 0) return 0;
    //     // Red - 0, Blue - 1, Green - 2.
    //     int case1 = helper(costs, 0, 0, 0);
    //     int case2 = helper(costs, 1, 0, 0);
    //     int case3 = helper(costs, 2, 0, 0);
    //     return Math.min(case1, Math.min(case2, case3));
    // }
    // private int helper(int[][] costs, int color, int row, int total) {
    //     // base
    //     if(row = costs.length) {
    //         return total;
    //     }
    //     // logic
    //     // If red, add the cost and check with blue and green in the next row.
    //     if(color == 0) {
    //         return Math.min(helper(costs, 1, row + 1, total + costs[row][0]), helper(costs, 2, row + 1, total + costs[row][0]));
    //     }
    //     if(color == 1) {
    //         return Math.min(helper(costs, 0, row + 1, total + costs[row][1]), helper(costs, 2, row + 1, total + costs[row][1]));
    //     }
    //     if(color == 2) {
    //         return Math.min(helper(costs, 0, row + 1, total + costs[row][2]), helper(costs, 1, row + 1, total + costs[row][2]));
    //     }
    //     return 74284;
    // }
}