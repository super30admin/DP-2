// Time Complexity : O(n) where n = number of rows
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Notes : Assign 3 variables to calculate the min between the current value and the other 2 non-adjacent values in the next row, finally take minimum of these 3 variables

public class PaintHouse {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0) return 0;
        
        int r = costs[costs.length - 1][0];
        int g = costs[costs.length - 1][1];
        int b = costs[costs.length - 1][2];
        
        if( costs.length > 1 ){
            for(int i = costs.length - 2; i >= 0; i--){
                int oldr = r, oldg = g;
                r = Math.min(costs[i][0] + g, costs[i][0] + b);
                g = Math.min(costs[i][1] + oldr, costs[i][1] + b);
                b = Math.min(costs[i][2] + oldr, costs[i][2] + oldg);
            }
        }
        
        return Math.min(r,Math.min(g,b));
    }
}
