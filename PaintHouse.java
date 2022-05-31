// Time Complexity : O(n)
// Space Complexity : O(1) ; Mutating given matrix
// Did this code successfully run on Leetcode: Yes

public class PaintHouse {

    public int minCost(int[][] costs) {

        if(costs == null || costs.length == 0) return 0;

        // int case1 = helper(costs, 0, 0, 0); //red
        // int case2 = helper(costs, 0, 1, 0); //blue
        // int case3 = helper(costs, 0, 2, 0); //green

        // return Math.min(case1, Math.min(case2, case3));

        return dp_approach(costs);
    }

    //houseIndex = row
    //colorUsed = color
    private int helper(int[][] costs, int row, int color, int costSoFar){
        //base
        if(row == costs.length) return costSoFar;


        //logic
        if(color == 0){
            return Math.min(
                    helper(costs, row + 1, 1, costSoFar + costs[row][0]),
                    helper(costs, row + 1, 2, costSoFar + costs[row][0])
            );
        }
        if(color == 1){
            return Math.min(
                    helper(costs, row + 1, 0, costSoFar + costs[row][1]),
                    helper(costs, row + 1, 2, costSoFar + costs[row][1])
            );
        }
        if(color == 2){
            return Math.min(
                    helper(costs, row + 1, 1, costSoFar + costs[row][2]),
                    helper(costs, row + 1, 2, costSoFar + costs[row][2])
            );
        }

        return 9999;
    }

    private int dp_approach(int[][] costs){

        for(int i = costs.length - 2; i >= 0; i--){
            costs[i][0] += Math.min(costs[i+1][1], costs[i+1][2]);
            costs[i][1] += Math.min(costs[i+1][0], costs[i+1][2]);
            costs[i][2] += Math.min(costs[i+1][0], costs[i+1][1]);
        }
        return Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2]));
    }
}
