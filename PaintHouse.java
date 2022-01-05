//Exhaustive approach
public class PaintHouse {
    public int minCost(int[][] costs) {
        if(costs.length == 0 || costs == null) return 0;
        int case1 = helper(costs, 0, 0, 0);
        int case2 = helper(costs, 0, 1, 0);
        int case3 = helper(costs, 0, 2, 0);
        return Math.min(case1 , Math.min(case2, case3));

    }
    private int helper(int[][] costs, int row, int color, int mincCost) {
        if(row == costs.length) {
            return mincCost;
        }
        if(color == 0) {
            return Math.min(helper(costs, row+1, 1, mincCost+costs[row][0]), helper(costs, row+1, 2, mincCost+costs[row][0]));
        }
        if(color == 1) {
            return Math.min(helper(costs, row+1, 0, mincCost+costs[row][1]), helper(costs, row+1, 2, mincCost+costs[row][1]));
        }
        if(color == 2) {
            return Math.min(helper(costs, row+1, 0, mincCost+costs[row][2]), helper(costs, row+1, 1, mincCost+costs[row][2]));
        }
        return 1000000;
    }
}


