/*
 *  Time Complexity: O(N) where N is the number of houses. 
 *  Space Complexity: O(1) Since we are mutating the existing array its taking constant space.
 *
 *  Did this code successfully run on Leetcode : Yes
 *  Any problem you faced while coding this : Design the approach to hold the min element.
 *
 *  Explanation: For each row we calculate and store the min amount required by coloring it in all the colors. It we take row 1, we update the minCost for coloring in blue to the house with min cost of coloring all the housed above except blue(either green or red). We can store the intermediate results in each row. We can get the final answer by finding the min value in the last row.
 */

class Solution {
    public int minCost(int[][] costs) {
        if(costs==null || costs.length==0) return 0;
        int minCost;
        for(int i=1;i<costs.length;i++){
            costs[i][0]+=Math.min(costs[i-1][1],costs[i-1][2]);
            costs[i][1]+=Math.min(costs[i-1][0],costs[i-1][2]);
            costs[i][2]+=Math.min(costs[i-1][1],costs[i-1][0]);
        }
        return Math.min(costs[costs.length-1][0], Math.min(costs[costs.length-1][1], costs[costs.length-1][2]));
    }
}
