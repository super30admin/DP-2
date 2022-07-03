// Time Complexity : O(n*3) = O(n)
// Space Complexity :O(n*3) = O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
import java.util.*;
class PaintHouse {
    public int minCost(int[][] costs) {

        if(costs == null || costs.length == 0) return 0;

        int n = costs.length;

        for(int i=n-2; i>=0; i--){
            //add the existing cost for colour 1 along with the min of cost from the previous row(house), other two colours(columns) since we shouldn't paint adjacent houses
            costs[i][0] = costs[i][0] + Math.min(costs[i+1][1] , costs[i+1][2]);

            //add the existing cost for colour 2 along with the min of cost from the previous row, other two colours(columns) since we shouldn't paint adjacent houses
            costs[i][1] = costs[i][1] + Math.min(costs[i+1][0] , costs[i+1][2]);

            //add the existing cost for colour 3 along with the min of cost from the previous row, other two colours(columns) since we shouldn't paint adjacent houses
            costs[i][2] = costs[i][2] + Math.min(costs[i+1][0] , costs[i+1][1]);
        }

        //Return the min of three columns from the final row(house)
        return Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2]));
    }
}