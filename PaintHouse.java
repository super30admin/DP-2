// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public int minCost(int[][] costs) {
        
        int n  = costs.length-1;
        if(costs == null || n+1 == 0 )
            return 0;
        else {
            for(int i = 1; i < costs.length; i++) {
                // Pick the min of previous row other 2 colors and add to current sum
                costs[i][0] += Math.min(costs[i-1][1],costs[i-1][2]);
                costs[i][1] += Math.min(costs[i-1][2],costs[i-1][0]);
                costs[i][2] += Math.min(costs[i-1][1],costs[i-1][0]);
            }
        }
        //Minimum cost for choosing different paints for different houses
        return Math.min(costs[n][0],Math.min(costs[n][1],costs[n][2]));
    }
}