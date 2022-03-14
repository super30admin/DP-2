// Time Complexity : O(n) n = no of houses
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Do not have leetcode premium, tried on sample cases.
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
APPROACH:
using the existing matrix as DP matrix and checking for the least value from the other column values in previous rows to get the total value.
Such that: For painting a house red in colour, will result in the value = Math.min(costs[i - 1][1], costs[i - 1][2]) and similarly for other colours.
 */

//Problem statement
//There are a row of n houses, each house can be painted with one of the three colors: red, blue or green.
//The cost of painting each house with a certain color is different. You have to paint all the houses such
//that no two adjacent houses have the same color.

//The cost of painting each house with a certain color is represented by a n x 3 cost matrix. For example,
//costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1
//with color green, and so on... Find the minimum cost to paint all houses.

//Note:
//All costs are positive integers.


public class paintHouse {
    public static int minCost(int[][] costs) {

        if(null == costs || costs.length == 0 ){
            return 0;
        }

        for (int i = 1; i < costs.length; i++) {
            costs[i][0] += Math.min(costs[i - 1][1], costs[i - 1][2]);
            costs[i][1] += Math.min(costs[i - 1][0], costs[i - 1][2]);
            costs[i][2] += Math.min(costs[i - 1][0], costs[i - 1][1]);
        }

        return Math.min(costs[costs.length - 1][0], Math.min(costs[costs.length - 1][1],costs[costs.length - 1][2]));
    }

    public static void main(String[] args){
        int[][] matrix = {{17,2,17},{16,16,5},{14,3,19}};
        System.out.println(minCost(matrix)); //10

        int[][] matrix2 = {{7,6,2}};
        System.out.println(minCost(matrix2)); //2
    }
}
