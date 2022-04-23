// Time Complexity : O(3*M) (since 3 colors)== O(M) where M is the number of houses
// Space Complexity : O(1) Since we are mutating the matrix and not using any extra space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach- bottom up DP, at each point add the cost of color x
//and the min of the two colors y and z from the next row.
public class PaintHouse {
    public int minCost(int[][] costs) {
        if(costs==null || costs.length==0) return 0;
        //array, color, row, currCost
        for(int i=costs.length-2;i>=0;i--){
            costs[i][0]= costs[i][0]+ Math.min(costs[i+1][1],costs[i+1][2]);
            costs[i][1]= costs[i][1]+ Math.min(costs[i+1][0],costs[i+1][2]);
            costs[i][2]= costs[i][2]+ Math.min(costs[i+1][1],costs[i+1][0]);
        }

        return Math.min(costs[0][0], Math.min(costs[0][1],costs[0][2]));
    }
}
