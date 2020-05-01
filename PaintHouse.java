package com.ds.rani.dp;

/**
 * There are a row of n houses, each house can be painted with one of the three colors: red, blue or green.
 * The cost of painting each house with a certain color is different. You have to paint all the houses such that
 * no two adjacent houses have the same color.
 * The cost of painting each house with a certain color is represented by a n x 3 cost matrix.
 * For example, costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1
 * with color green, and so on... Find the minimum cost to paint all houses.
 * <p>
 * Follow Up: Optimize for Space
 * Example:
 * Input: [[17,2,17],[16,16,5],[14,3,19]] Output: 10
 * Explanation: Paint house 0 into blue, paint house 1 into green, paint house 2 into blue.
 * Minimum cost: 2 + 5 + 3 = 10.
 */
//Approach:create 2D array odf size number of houses by number of colors then find out the min cost to paint every house
public class PaintHouse {

    //Time complexity o(n*m)
    //Space complexity o(n*m)  where n  number of houses and m is number of colors
    public static int minCost(int[][] costs) {
        //edge case
        if (costs == null || costs.length == 0) return 0;

        //number of houses
        int n = costs.length;
        int[][] dp = new int[n][3];
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];
        //   0  1  2
        //0  [17,2,17]
        //1  [16,16,5]
        //2  [14,3,19]]
        //If I am selecting o th color for current(i th house) then take min value among 1 or 2 for previous house
        // because I cant take oth value (same color) for adjacent house
        for (int i = 1; i < n; i++) {
            dp[i][0] = costs[i][0] + Math.min( dp[i - 1][1], dp[i - 1][2] );
            dp[i][1] = costs[i][1] + Math.min( dp[i - 1][0], dp[i - 1][2] );
            dp[i][2] = costs[i][2] + Math.min( dp[i - 1][0], dp[i - 1][1] );
        }
        return Math.min( Math.min( dp[n - 1][0], dp[n - 1][1] ), dp[n - 1][2] );
    }

    public static void main(String[] args) {
        int[][] costs = {{17, 2, 17}, {16, 16, 5}, {14, 3, 19}};
        System.out.println( PaintHouse.minCost( costs ) );
    }
}
