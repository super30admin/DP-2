package DynamicProgramming2;

public class question22_paintHouse {

    /*
    Brute Force
        Time Complexity: 3 * 2 ^ n --> exponential --> O(2 ^ n)
        SPace Complexity: O(n)
     */
    public int minCostRecursion(int[][] costs) {
        if(costs == null || costs.length == 0) return 0;

        int case1 = helper(costs, 0, 0, 0); // Green
        int case2 = helper(costs, 1, 0, 0); // Blue
        int case3 = helper(costs, 2, 0, 0); // Red

        return Math.min(case1, Math.min(case2, case3));
    }

    private int helper(int[][] costs, int color, int row, int minCost) {
        //Base case
        if(row == costs.length) return minCost;

        //Logic
        if(color == 0)
            return Math.min(helper(costs, 1, row + 1, minCost + costs[row][0]),
                    helper(costs, 2, row + 1, minCost + costs[row][0]));

        if(color == 1)
            return Math.min(helper(costs, 0, row + 1, minCost + costs[row][1]),
                    helper(costs, 2, row + 1, minCost + costs[row][1]));

        if(color == 2)
            return Math.min(helper(costs, 0, row + 1, minCost + costs[row][2]),
                    helper(costs, 1, row + 1, minCost + costs[row][2]));

        return 99999;
    }

    /*
    Dynamic Programming Approch:
        Time Complexity: O(n)
        Space Complexity: O(n)
     */


    public int minCostDP(int[][] costs) {
        if(costs == null || costs.length == 0) return 0;

        for(int i = costs.length - 2 ; i >= 0 ; i--) {
            costs[i][0] = costs[i][0] + Math.min(costs[i+1][1], costs[i+1][2]);
            costs[i][1] = costs[i][1] + Math.min(costs[i+1][0], costs[i+1][2]);
            costs[i][2] = costs[i][2] + Math.min(costs[i+1][0], costs[i+1][1]);
        }
        return Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2]));
    }
}