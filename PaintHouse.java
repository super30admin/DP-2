// Time Complexity : O(N) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int minCost(int[][] costs) {
        if(costs.length==0)
            return 0;
        
        int[] previous = costs[0];
        
        for(int i=1;i<costs.length;i++){
            int[] current = new int[costs[0].length];
            
            current[0] = Math.min(previous[1],previous[2])+costs[i][0];
            current[1] = Math.min(previous[0],previous[2])+costs[i][1];
            current[2] = Math.min(previous[0],previous[1])+costs[i][2];
            
            previous = current;
        }
        
        return Math.min(Math.min(previous[0],previous[1]),previous[2]);
    }
}