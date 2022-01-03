public class Paint {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        for (int i = costs.length - 2; i >= 0; i--) {
            costs[i][0] += Math.min(costs[i + 1][1], costs[i + 1][2]);
            costs[i][1] += Math.min(costs[i + 1][0], costs[i + 1][2]);
            costs[i][2] += Math.min(costs[i + 1][0], costs[i + 1][1]);
        }
        return Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2]));
    }
}

class PaintRecurse {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        int case1 = helper(costs, 0, 0, 0);
        int case2 = helper(costs, 0, 1, 0);
        int case3 = helper(costs, 0, 2, 0);
        return Math.min(case1, Math.min(case2, case3));
    }

    private int helper(int[][] costs, int row, int color, int colorSoFar) {
        if (row == costs.length) {
            return colorSoFar;
        }
        if (color == 0) {
            return (Math.min(helper(costs, row + 1, 1, colorSoFar + costs[row][1]),
                    helper(costs, row + 1, 2, colorSoFar + costs[row][2])));
        } else if (color == 1) {
            return (Math.min(helper(costs, row + 1, 0, colorSoFar + costs[row][0]),
                    helper(costs, row + 1, 2, colorSoFar + costs[row][2])));
        } else {
            return (Math.min(helper(costs, row + 1, 0, colorSoFar + costs[row][0]),
                    helper(costs, row + 1, 1, colorSoFar + costs[row][1])));
        }
    }
}
