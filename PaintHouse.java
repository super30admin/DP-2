/*
Given a row of n houses, each house can be coloured with any of the three colours: 
let these be red blue or green. 
The cost for painting a particular house with a particular colour is going to be different. 
You have to colour the house in such a way that no two adjacent houses will have the same colour. 
The cost for painting a house with any colour is represented by a n X 3 cost matrix 
where cost for painting house 0 with colour red is cost[0][0] 
and cost for painting house 4 with green colour is cost[4][2] and so on.
Calculate the minimum cost to paint all houses. try to optimize it for space !!

TC: O(n) - n - number of houses, and we make constant number of operations (3) for each house
SC: O(1) - no additional space, we are modifying the original matrix
Leetcode Run - Yes
Problems faced - Was not able to come up with recursive solution

Approach:
1. For every house i, find the minimum of painting (i-1)st house, with either of the 2 different colors.
2. As, we do this for every house, the final house, will have 3 values for painting it, with R/G/B color,
and the sum of the minimum cost with the constraints
3. Final answer is the minimum of the three color cost.
Why is this a DP problem - every problem of coloring house 'i' can be broken down into coloring house upto 'i-1'
*/

public class PaintHouse {
    public static int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }

        for (int i = 1; i < costs.length; i++) {
            // cost to paint with color 'C' + previous min cost of painting with color other than 'C'
            costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]);
            costs[i][1] += Math.min(costs[i-1][0], costs[i-1][2]);
            costs[i][2] += Math.min(costs[i-1][1], costs[i-1][0]);
        }

        return Math.min(costs[costs.length - 1][0], 
                        Math.min(costs[costs.length - 1][1], costs[costs.length - 1][2]));
    }

    public static void main(String args[]) {
        int costs[][] = new int[][] {
            {1, 5, 6},
            {4, 2, 3},
            {3, 1, 1}
        };

        System.out.println(minCost(costs));
    }
}