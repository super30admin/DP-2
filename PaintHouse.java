


// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

public class PaintHouse {
	public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0){
            return 0;
        }
        int case1 = helper(costs, 0, 0, 0); //Blue
        int case2 = helper(costs, 1, 0, 0); //Green
        int case3 = helper(costs, 2, 0, 0); //Red
        return Math.min(case1, Math.min(case2, case3));
    }
    private int helper(int[][] costs,int color, int row, int minCost){
        // base
        if(row == costs.length) return minCost;
        // logic
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < 3; i++){
            if(color != i){
                 min= Math.min(min, helper(costs, i, row + 1, minCost +costs[row][color]));
            }
        }
        return min;
    }

}
