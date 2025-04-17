// Time Complexity : O(m) m-number of houses
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

// Approach:
// Starting from last house, initialize the cost of painting with each color.
// Move backward, updating the cost of painting current house with each color by adding minimum of other two colors from the next house.
// Return the minimum cost among three colors for the first house.

class Solution {
    public int minCost(int[][] costs) {
        int m = costs.length;
        int n = costs[0].length; 

        int colorR = costs[m-1][0];
        int colorB = costs[m-1][1];
        int colorG = costs[m-1][2];

        for(int i=m-2; i>=0; i--) {
            int tempR = colorR;
            int tempB = colorB;

            colorR = costs[i][0] + Math.min(colorB, colorG);
            colorB = costs[i][1] + Math.min(tempR, colorG);
            colorG = costs[i][2] + Math.min(tempR, tempB);
        }

        return Math.min(colorR, Math.min(colorB, colorG));
    }
}

