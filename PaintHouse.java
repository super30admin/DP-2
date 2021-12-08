/**
 Time complexity is O(3 ^ n)
 Space complexity is also same it is exponential
 Appproch: So here we are taking all combinations of house colored with other house colored
 */
class Solution {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0) {
            return 0;
        }

        int cost0 = colorHelper(costs, 0, 0, 0);
        int cost1 = colorHelper(costs, 1, 0, 0);
        int cost2 = colorHelper(costs, 2, 0, 0);

        return Math.min(cost0, Math.min(cost1, cost2));
    }

    private int colorHelper(int[][] costs, int color, int row, int costAccured) {
        if(row >= costs.length){
            return costAccured;
        }

        if(color == 0){
            return Math.min(colorHelper(costs, 1, row + 1, costAccured + costs[row][0]),
                    colorHelper(costs, 2, row + 1, costAccured + costs[row][0]));
        }

        if(color == 1){
            return Math.min(colorHelper(costs, 0, row + 1, costAccured + costs[row][1]),
                    colorHelper(costs, 2, row + 1, costAccured + costs[row][1]));
        }

        if(color == 2){
            return Math.min(colorHelper(costs, 1, row + 1, costAccured + costs[row][2]),
                    colorHelper(costs, 0, row + 1, costAccured + costs[row][2]));
        }


        return Integer.MAX_VALUE;
    }
}