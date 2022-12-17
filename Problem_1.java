// Paint House
// Time Complexity : O(m)
// Space Complexity : O(m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Approach
// calculating the sum for R,B,G houses from the last row to 1st row.
// for 3 colors, will consider 3 variable. For the sum(val), consider that index and minimum of other two color of last row and replace the val. Before replacing, store it in a temp variable for further calculation.



class Solution {
    public int minCost(int[][] costs) {
        int m =costs.length;
        int valR = costs[m-1][0];
        int valB = costs[m-1][1];
        int valG = costs[m-1][2];

        for(int i = m-2; i >= 0; i--) {
            int tempR = valR;
            valR = costs[i][0] + Math.min(valB, valG);
            int tempB = valB;
            valB = costs[i][1] + Math.min(tempR, valG);
            valG = costs[i][2] + Math.min(tempR, tempB);
        }
        return Math.min(valR, Math.min(valB, valG));
    }
}