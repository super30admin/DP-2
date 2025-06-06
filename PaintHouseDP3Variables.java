// Time Complexity : O(n), where n is the number of houses
// Space Complexity : O(1), using constant space for color cost tracking
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach:
// This is a space-optimized bottom-up DP solution to the "Paint House" problem.
// Instead of using a DP matrix, we track only the last row values (costs of painting the next house).
// We iterate from the second-last house upwards, calculating the minimum cost to paint each house
// by considering the previous colors' costs (excluding same color for adjacent houses).
// Finally, we return the minimum among the three accumulated color costs for the first house.

class Solution {
    public int minCost(int[][] costs) {
        int m = costs.length;
        int n = costs[0].length;

        // Initialize with the last house's painting costs
        int colorR = costs[m - 1][0];
        int colorB = costs[m - 1][1];
        int colorG = costs[m - 1][2];

        // Iterate from the second-last house to the top
        for (int i = m - 2; i >= 0; i--) {
            int tempR = colorR; // Store previous values temporarily
            int tempB = colorB;

            // Update each color cost by choosing the minimum of the other two colors
            colorR = costs[i][0] + Math.min(colorB, colorG);
            colorB = costs[i][1] + Math.min(tempR, colorG);
            colorG = costs[i][2] + Math.min(tempR, tempB);
        }

        // Return the minimum total cost from the first house
        return Math.min(Math.min(colorR, colorB), colorG);
    }
}
