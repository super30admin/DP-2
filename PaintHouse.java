// Time Complexity : O(n)), 
// Space Complexity : O(1), no extra space taken
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :    No
package dp2;

/**
 *
 * @author shilpa
 */
public class PaintHouse {
    public int rob(int[][] costs) {
        
        if(costs.length == 0 || costs == null) return 0;
        for(int i = costs.length -2; i >= 0; i--){
        costs[i][2] = costs[i][2] + Math.min(costs[i+1][0], costs[i+1][1]);
        costs[i][1] = costs[i][1] + Math.min(costs[i+1][0], costs[i+1][2]);
        costs[i][0] = costs[i][0] + Math.min(costs[i+1][1], costs[i+1][2]);
        }
         return Math.min(costs[0][2], Math.min(costs[0][1], costs[0][0]));
        
    }
}
