// Time Complexity : O(n); n -> no. of houses
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * In this problem, I am considering each path to evaluate the minimum path such that I do not go to the same columned row in my next iteration.
 * I am independently calculating the costs by starting from red, blue and green painted houses. 
 * If I am at a red painted house currently, I'll evaluate the cost by tracing the path with green painted house and blue painted house. I'll
 * consider the minimum cost out of the two. Similarly, I'll calculate the costs by starting at green and blue painted house.
 */



class Solution {
    public int minCost(int[][] costs) {
        //edge case
        if(costs == null || costs.length == 0) {
            return 0;
        }
        for(int i = 1; i < costs.length; i++) {
            costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]);
            costs[i][1] += Math.min(costs[i-1][0], costs[i-1][2]);
            costs[i][2] += Math.min(costs[i-1][1], costs[i-1][0]);
        }
        return Math.min(costs[costs.length-1][0], Math.min(costs[costs.length-1][1], costs[costs.length-1][2]));
    }
}