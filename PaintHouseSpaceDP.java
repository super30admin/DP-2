// Time Complexity : O(3*2^n) = O(2^n)
// Space Complexity : O(1)
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

class Solution {
    public int minCost(int[][] costs) {
        // using recursion
        // using dp ( compute the cost in the same arr)
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
        // choose blue, green , red house and then add cost of that house and min
        // between other two adjacent houses
        for (int i = costs.length - 2; i >= 0; i--) {
            costs[i][0] = costs[i][0] + Math.min(costs[i + 1][1], costs[i + 1][2]);
            costs[i][1] = costs[i][1] + Math.min(costs[i + 1][0], costs[i + 1][2]);
            costs[i][2] = costs[i][2] + Math.min(costs[i + 1][0], costs[i + 1][1]);
        }
        return Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2]));
    }

}