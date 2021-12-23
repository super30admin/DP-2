public class PaintHouse {
    public int minCost(int[][] costs) {

        // TC : O(N)
        // SC : O(N)

        if (costs == null || costs.length == 0)
            return 0;
        // start calculating the costs from the last second row and iterate it till the
        // 1st row
        for (int i = costs.length - 2; i >= 0; i--) {
            costs[i][0] = costs[i][0] + Math.min(costs[i + 1][1], costs[i + 1][2]);
            costs[i][1] = costs[i][1] + Math.min(costs[i + 1][0], costs[i + 1][2]);
            costs[i][2] = costs[i][2] + Math.min(costs[i + 1][0], costs[i + 1][1]);
        }
        // the final minimum costs of each color is stored in the top row. Finding the
        // minimum of all the items in the qst row gives the min cost required to paint
        // the house
        return Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2]));

    }

}

// There are a row of n houses, each house can be painted with one of the three
// colors: red, blue or green.
// The cost of painting each house with a certain color is different.
// You have to paint all the houses such that no two adjacent houses have the
// same color.

// The cost of painting each house with a certain color is represented by a n x
// 3 cost matrix.
// For example, costs[0][0] is the cost of painting house 0 with color red;
// costs[1][2] is the cost of painting house 1 with color green, and so on...
// Find the minimum cost to paint all houses.