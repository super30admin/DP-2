/*
* Approach:
*  1. Exhaustive: 
        Explore all possibilites of each colors from house1,
            if last house is reached return the total paint cost.
* 
*  2. Tabulation:
        Start from the last house, copy the costs for all colors.

        prev house costs will be:
            cost of current color + min of next house other colors
* 
*  3. Space optimization:
        As we are depending on 2 rows, 
            we can take 2 one-dimensional arrays with curr and prev.
* 
* 
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(houses*colors)
* 
* Space Complexity: O(colors)
* 
*/

public class PaintHouse {
    // exhaustive
    // private int minCost(int[][] cost, int colorIndex,
    // int houseIndex, int paintCost) {
    // if (houseIndex == cost.length)
    // return paintCost;

    // int minPaintCost = Integer.MAX_VALUE;

    // for (int index = 0; index < cost[0].length; index++) {
    // if (index != colorIndex)
    // minPaintCost = Integer.min(minPaintCost,
    // minCost(cost, index, houseIndex + 1,
    // paintCost + cost[houseIndex][index]));
    // }

    // return minPaintCost;
    // }
    // private int getMinCost(int colorIndex, int houseIndex, int[][] dp) {
    // int minCostValue = Integer.MAX_VALUE;

    // for (int index = 0; index < dp[0].length; index++) {
    // if (index != colorIndex)
    // minCostValue = Integer.min(minCostValue, dp[houseIndex][index]);
    // }

    // return minCostValue;
    // }

    private int getMinCost(int colorIndex, int[] arr) {
        int minCostValue = Integer.MAX_VALUE;

        for (int index = 0; index < arr.length; index++) {
            if (index != colorIndex)
                minCostValue = Integer.min(minCostValue, arr[index]);
        }

        return minCostValue;
    }

    public int minCost(int[][] costs) {
        // return minCost(costs, -1, 0, 0);

        // tabulation
        int houses = costs.length,
                colors = costs[0].length;

        // int[][] dp = new int[houses][colors];

        // for (int index = 0; index < colors; index++) {
        // dp[houses - 1][index] = costs[houses - 1][index];
        // }

        // for (int house = houses - 2; house >= 0; house--) {
        // for (int index = 0; index < colors; index++)
        // dp[house][index] = costs[house][index] +
        // getMinCost(index, house + 1, dp);
        // }

        // return getMinCost(-1, 0, dp);

        int[] curr = new int[colors],
                prev = new int[colors];

        for (int index = 0; index < colors; index++)
            prev[index] = costs[houses - 1][index];

        for (int house = houses - 2; house >= 0; house--) {
            for (int index = 0; index < colors; index++)
                curr[index] = costs[house][index] + getMinCost(index, prev);

            prev = curr.clone();
        }

        return getMinCost(-1, prev);
    }
}
