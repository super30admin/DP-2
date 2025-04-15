// Leetcode premium problem
// we are given with row of house
// we have to paint these houses
// cost of paint these houses with certain colors
// constraint - no 2 adjacent houses can be painted with same color
// we have to find the minimum cost of painting these houses

public class PaintHouse { // exhaustive Approach 01
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }

        // Start with each color for the first house
        int colorR = helper(costs, 0, 0, 0); // Start with red
        int colorB = helper(costs, 1, 0, 0); // Start with blue
        int colorG = helper(costs, 2, 0, 0); // Start with green

        // Return the minimum of all three starting points
        return Math.min(colorR, Math.min(colorB, colorG));
    }

    private int helper(int[][] costs, int color, int i, int total) {
        // base case
        if (i == costs.length) {
            return total;
        }

        if (color == 0) { // red color for the current house
            return Math.min(helper(costs, 1, i + 1, total + costs[i][0]), // next house is blue
                            helper(costs, 2, i + 1, total + costs[i][0])); // next house is green
        } else if (color == 1) { // blue color for the current house
            return Math.min(helper(costs, 0, i + 1, total + costs[i][1]), // next house is red
                            helper(costs, 2, i + 1, total + costs[i][1])); // next house is green
        } else if (color == 2) { // green color for the current house
            return Math.min(helper(costs, 0, i + 1, total + costs[i][2]), // next house is red
                            helper(costs, 1, i + 1, total + costs[i][2])); // next house is blue
        }

        return Integer.MAX_VALUE; // This line is unreachable but added for safety
    }
}
