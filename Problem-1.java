// Time Complexity : O(N)
// Space Complexity : O(1) [using in place processing of min costs]
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

// We need to find the minimum cost to paint all houses.
// That means we need to return the total.
// In the same "costs" matrix we will keep on adding the minimum cost based looking previous house 
// (i.e. looking at the above row, adding minimum amoung diffrent color than the current color) 
class Solution1 {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0)
            return 0;

        // no. of houses
        int n = costs.length;

        // naming indexes as color for better understanding
        int red = 0, green = 1, blue = 2;

        // iterate the matrix from 2nd house to nth house.
        // we begin from 2nd house because 1st house can be any color with min cost
        // and based on that we choose current color by comparing it with cost of other
        // two colors.
        // and then adding it in place
        for (int i = 1; i < n; i++) {
            // we use below pattern:
            // currentColorCost = currentColorCost + min(previous other color costs)

            // red
            costs[i][red] = costs[i][red] + Math.min(costs[i - 1][green], costs[i - 1][blue]);

            // green
            costs[i][green] = costs[i][green] + Math.min(costs[i - 1][red], costs[i - 1][blue]);

            // blue
            costs[i][blue] = costs[i][blue] + Math.min(costs[i - 1][red], costs[i - 1][green]);
        }

        // minimum cost value will be in the last row
        // either in red or blue or green column (get min of each pair and min from
        // those pairs)
        int redGreenMin = Math.min(costs[n - 1][red], costs[n - 1][green]);
        int greenBlueMin = Math.min(costs[n - 1][green], costs[n - 1][blue]);

        return Math.min(redGreenMin, greenBlueMin);
    }
}