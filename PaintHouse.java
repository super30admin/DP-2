/**
Time Complexity : O(n)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
*/

class Solution {
    /**
    Approach:
    - We are given the costs array which is a 2-D matrix. Check the base condition and return 0 if any of those are true.
    - Starting from the 2nd row, we compute the minimum cost for each of red, green, blue.
    - Return the minimum value in the last row because that gives the minimum cost of painiting all houses.
    */
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0 || costs[0].length == 0) {
            return 0;
        }
        int n = costs.length;
        
        for(int i = 1; i < n; i++) {
            //Red
            costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]);
            
            //Green
            costs[i][1] += Math.min(costs[i-1][0], costs[i-1][2]);
            
            //Blue
            costs[i][2] += Math.min(costs[i-1][0], costs[i-1][1]);
        }
        return Math.min(costs[n-1][0], Math.min(costs[n-1][1], costs[n-1][2]));
    }
}
