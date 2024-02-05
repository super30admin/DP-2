// Time Complexity : O(n) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : 


// Your code here along with comments explaining your approach

class Solution {
    public int minCost(int[][] costs) {
        int R = costs[0][0];
        int B = costs[0][1];
        int G = costs[0][2];

        // we are building the tree inverted. 
        for(int i = 1 ; i < costs.length ; i++){
            int tempR = R;
            R = costs[i][0] + Math.min(B , G); //cost of painting house red + min of b&g
            int tempB = B;
            B = costs[i][1] + Math.min(tempR , G);
            G = costs[i][2] + Math.min(tempR,tempB);
        }

        return Math.min(R, Math.min(B,G));
    }


}