//Problem: 256. Paint House
/** 3 Pointer Approcach:
 * Brute force was to draw a tree for each color which go exponential. 
 * Used DP approach.
 * Updated value for each column (color) for each house from previous houses coloring amount, 
 * taking the minimim of coloring amount for left houses.
 * 
 * Will keep first row as it (for house 1) and then expored BEST options for next houses sequentially
 */ 
//
//time Complexity :
// O(N) Number of houses {since we need to iterate each house row and make choice of other 2 colors
// if there would be more colrs say Z then complexity would be N*M } 

// Space Complexity :
// O(1) - updated same array and not used extra space.

// Did this code successfully run on Leetcode : YES.
// Any problem you faced while coding this : NO.

class Solution {
    public int minCost(int[][] costs) {
        
        if(costs.length == 0)
            return 0;
        
        for(int row=1; row<costs.length; row++){
              costs[row][0] += Math.min(costs[row-1][1],   costs[row-1][2]);  // choosing Minimum cost from previous houses 
                                                                              //and of different color  
              costs[row][1] += Math.min(costs[row-1][0],   costs[row-1][2]); 
              costs[row][2] += Math.min(costs[row-1][1],   costs[row-1][0]); 
        }
        
        // get the minimum form the last row
        return  Math.min(Math.min(costs[costs.length-1][0], costs[costs.length-1][1]), costs[costs.length-1][2]);
    }
}