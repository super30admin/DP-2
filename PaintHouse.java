// Time Complexity : O(N) N = no of houses.
// Space Complexity : O(N) N= no of houses.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
//1.Initially the minimum cost to paint the house Red, Blue, Green.
//2. When we go to house 2 the minimum cost to paint a particular house is minimun of the cost to paint blue or green of house 1.
//3. Similary we do it until the last house and return the minimum of the last house to paint it either with red, green , blue.

// There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. 
//The cost of painting each house with a certain color is different. You have to paint all the houses such 
//that no two adjacent houses have the same color.

// The cost of painting each house with a certain color is represented by a n x 3 cost matrix. 
//For example, costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of 
//painting house 1 with color green, and so on... Find the minimum cost to paint all houses.

// Note: All costs are positive integers.
public class PaintHouse {

    public int paint(int[][] costs) {

        if (costs.length == 0)
            return 0;
        for (int i = 1; i < costs.length; i++) {
            costs[i][0] += Math.min(costs[i - 1][1], costs[i - 1][2]);
            costs[i][1] += Math.min(costs[i - 1][0], costs[i - 1][2]);
            costs[i][2] += Math.min(costs[i - 1][0], costs[i - 1][1]);

        }
        return Math.min(costs[costs.length - 1][0], Math.min(costs[costs.length - 1][1], costs[costs.length - 1][2]));

    }

    public static void main(String args[]) {
        PaintHouse obj = new PaintHouse();
        int[][] costs = { { 17, 2, 17 }, { 16, 16, 5 }, { 14, 3, 19 } };
        System.out.println(obj.paint(costs));

    }
}