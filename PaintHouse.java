// Time Complexity : O(n) where in the total number of houses, since total number of colors is costant ie 3.
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int minCost(int[][] costs) {
        for(int i = costs.length-2;i>=0;i--){
            //j=0 means color = red. so we cannot choose red color, we chose blue or green
            costs[i][0]=costs[i][0]+(Math.min(costs[i+1][1],costs[i+1][2]));
            //j=1 means color = blue. so we cannot choose blue color, we choose red or green
            costs[i][1]=costs[i][1]+(Math.min(costs[i+1][0],costs[i+1][2]));
            //j=2 means color = green. so we cannot choose green color, we choose red or blue
            costs[i][2]=costs[i][2]+(Math.min(costs[i+1][0],costs[i+1][1]));
        }
        return Math.min(costs[0][0],Math.min(costs[0][1],costs[0][2]));
    }
}