/*
 * #256. Paint House
 * 
 * There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by a n x 3 cost matrix. For example, costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1 with color green, and so on... Find the minimum cost to paint all houses.

Note:
All costs are positive integers.

Example:

Input: [[17,2,17],[16,16,5],[14,3,19]]
Output: 10
Explanation: Paint house 0 into blue, paint house 1 into green, paint house 2 into blue. 
             Minimum cost: 2 + 5 + 3 = 10.
             
 */

/*
 * Time Complexity: O (N) -> To traverse the rows/houses in a matrix
 * 
 * Space Complexity: O (1) -> not using any extra space
 * 
 * Did this code successfully run on leetcode: Yes
 * 
 * Any problem you faced while coding this: No
 * 
 */


package com.s30.edu.DP2;

// In this approach, we are manipulating the input array
public class PaintHouse {
	
	public int minCost(int[][] costs) {
		// Base condition, if given 2D array is empty, return 0
        if(costs.length == 0){
            return 0;
        }
        
        // We start traversing with the 2nd house(index=1)
        // First, if we paint 2nd house with red color, we can choose Green or Blue color for 1st house, so we take minimum of the two costs and add it to cost of 2nd house with Red color
        // if we paint 2nd house with green color, we can choose Red or Blue color for 1st house, so we take minimum of the two costs and add it to cost of 2nd house with Green color
        // if we paint 2nd house with blue color, we can choose Red or Green color for 1st house, so we take minimum of the two costs and add it to cost of 2nd house with Blue color
        // Now, we have computed minimum cost to paint house with R, G, or B color for both 1st and 2nd houses (values added in 2nd house)
        
        // Repeat same steps for last/3rd house as well which will consist minimum costs to paint all three houses with R, B, G color
        // After traversing all houses, return the minimum of all three values/costs from 3rd house 
        
        for(int i = 1; i <= costs.length - 1; i++){
            costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]); // Compute min cost to paint the ith house with red color
            costs[i][1] += Math.min(costs[i-1][0], costs[i-1][2]); // Compute min cost to paint the ith house with green color
            costs[i][2] += Math.min(costs[i-1][0], costs[i-1][1]); // Compute min cost to paint the ith house with blue color
        }
        
        return Math.min(costs[costs.length-1][0], Math.min(costs[costs.length-1][1], costs[costs.length-1][2]));
        
    }
	
}
