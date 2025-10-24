// Time Complexity :O(n) 
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :no (premium question)
// Any problem you faced while coding this :no
// Solved using Bottom-up Dp.
// Start from the last house, and move forward calculating the min cost of painting each house in front.
// Use three variables to hold the cost of painting with three colors. 

class Solution {
    public int minCost(int[][] costs) {
        int m = costs.length;//number of houses
        int R = costs[m-1][0];
        int B = costs[m-1][1];
        int G = costs[m-1][2];
        for(int i = m - 2; i >= 0; i--) {
            int tempR = R;//store in temp variables since it is overwritten in next step
            int tempB = B;
            //calculate new costs based on color of i+1 th house
            R = costs[i][0] + Math.min(B, G);
            B = costs[i][1] + Math.min(tempR, G);
            G = costs[i][2] + Math.min(tempR, tempB);
        }
        return Math.min(R, Math.min(B, G));
    }
}


