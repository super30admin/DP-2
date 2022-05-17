// Time Complexity : O(mn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int minCost(int[][] costs) {
        //At each house the min cost of choosing that paint will be the sum of that piant and min of the min sum of two other paint upto the previous house.
        for(int i=1; i<costs.length; i++){
            costs[i][0]+=Math.min(costs[i-1][1], costs[i-1][2]);
            costs[i][1]+=Math.min(costs[i-1][0], costs[i-1][2]);
            costs[i][2]+=Math.min(costs[i-1][0], costs[i-1][1]);
        }
        return Math.min(costs[costs.length-1][0], Math.min(costs[costs.length-1][1], costs[costs.length-1][2]));
    }
}
