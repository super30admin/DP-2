class Solution {
    public int helper(int[][] costs, int row, int color, int amt) {
        if(row >= costs.length) {
            return amt;
        }
        if(color == 0) {
            return Math.min(helper(costs, row + 1, 1, amt + costs[row][color]),
                    helper(costs, row + 1, 2, amt + costs[row][color]));
        }
        if(color == 1) {
            return Math.min(helper(costs, row + 1, 0, amt + costs[row][color]),
                    helper(costs, row + 1, 2, amt + costs[row][color]));
        }
        if(color == 2) {
            return Math.min(helper(costs, row + 1, 0, amt + costs[row][color]),
                    helper(costs, row + 1, 1, amt + costs[row][color]));
        }
        return -1;
    }
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0) {
            return 0;
        }
        int case1 = helper(costs, 0, 0, 0);
        int case2 = helper(costs, 0, 1, 0);
        int case3 = helper(costs, 0, 2, 0);
        return Math.min(case1, Math.min(case2, case3));
    }
}