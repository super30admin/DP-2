// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : NO submission 
// Any problem you faced while coding this : No

//We work backwards from the last house, storing just 3 variables for the colors.
//For each house, we update the color costs based on the min of the other two from the next house.
//Finally, we return the minimum among the three updated values.

class Solution {
    public int minCost(int[][] costs) {
        int m = costs.length;
        int n = costs[0].length;

        int colorR = costs[m-1][0];
        int colorB = costs[m-1][1];
        int colorG = costs[m-1][2];

        for(int i = m - 2; i >= 0; i--) {
            int tempR = colorR;
            int tempB = colorB;

            colorR = costs[i][0] + Math.min(colorB, colorG);
            colorB = costs[i][1] + Math.min(tempR, colorG);
            colorG = costs[i][2] + Math.min(tempR, tempB);
        }

        return Math.min(colorR, Math.min(colorB, colorG));
    }
}
