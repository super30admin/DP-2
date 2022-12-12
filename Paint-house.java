// Time Complexity : O(n) where is number of houses
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int minCost(int[][] costs) {
        int m = costs.length;
        int valR = costs[m-1][0];
        int valG = costs[m-1][1];
        int valB = costs[m-1][2];
        
        for(int i = m - 2; i >= 0; i--){
            int tempR = valR;
            valR = costs[i][0] + Math.min(valG, valB);
            int tempG = valG;
            valG = costs[i][1] + Math.min(tempR, valB);
            valB = costs[i][2] + Math.min(tempR, tempG);            
        }
        return Math.min(valR, Math.min(valB, valG));
    }    
}
