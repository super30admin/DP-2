class Solution {
    public int minCost(int[][] costs) {
        // using recursion
        // null check
        if (costs == null || costs.length == 0) {
            return 0;
        }

        int case1 = helper(costs, 0, 0, 0); // blue
        int case2 = helper(costs, 1, 0, 0); // green
        int case3 = helper(costs, 2, 0, 0); // red

        return Math.min(case1, Math.min(case2, case3));

    }

    private int helper(int[][] costs, int color, int row, int minCost) {
        // base
        if (row == costs.length)
            return minCost;

        // logic
        // choose
        if (color == 0) {// blue
            return Math.min(helper(costs, 1, row + 1, minCost + costs[row][0]),
                    helper(costs, 2, row + 1, minCost + costs[row][0]));
        }
        if (color == 1) {// green
            return Math.min(helper(costs, 0, row + 1, minCost + costs[row][1]),
                    helper(costs, 2, row + 1, minCost + costs[row][1]));
        }
        if (color == 2) { // red
            return Math.min(helper(costs, 0, row + 1, minCost + costs[row][2]),
                    helper(costs, 1, row + 1, minCost + costs[row][2]));
        }

        return 123;
    }

}