// Time Complexity : O(2^n * 3), where n is the number of houses (due to two recursive calls at each level),
// 3 can be ignored which belongs to the no.of colors
// Space Complexity : O(n), due to the recursion stack depth
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach:
// We are solving the "Paint House" problem using a brute-force recursive approach.
// Each house can be painted with one of three colors (R, B, G), and no two adjacent houses can have the same color.
// We explore all valid color combinations recursively and calculate the total cost for each path.
// At each step, we "choose" a color and recursively call the next house with updated total cost and a different color.
// Finally, we return the minimum cost among all valid combinations.

class Solution {
    public int minCost(int[][] costs) {
        // Try all 3 color options for the first house and return the minimum total cost
        int colorR = helper(costs, 0, 0, 0); // Starting with Red
        int colorB = helper(costs, 1, 0, 0); // Starting with Blue
        int colorG = helper(costs, 2, 0, 0); // Starting with Green

        // Return the minimum of the three possible paths
        return Math.min(Math.min(colorR, colorB), colorG);
    }

    // Recursive helper function
    private int helper(int[][] costs, int color, int i, int totalCost) {
        // Base Case: All houses are painted
        if (i == costs.length) return totalCost;

        // If current color is Red, next house can be painted Blue or Green
        if (color == 0) {
            return Math.min(
                    helper(costs, 1, i + 1, totalCost + costs[i][1]), // Paint next house Blue
                    helper(costs, 2, i + 1, totalCost + costs[i][2])  // Paint next house Green
            );
        }
        // If current color is Blue, next house can be painted Red or Green
        else if (color == 1) {
            return Math.min(
                    helper(costs, 0, i + 1, totalCost + costs[i][0]), // Paint next house Red
                    helper(costs, 2, i + 1, totalCost + costs[i][2])  // Paint next house Green
            );
        }
        // If current color is Green, next house can be painted Red or Blue
        else {
            return Math.min(
                    helper(costs, 0, i + 1, totalCost + costs[i][0]), // Paint next house Red
                    helper(costs, 1, i + 1, totalCost + costs[i][1])  // Paint next house Blue
            );
        }
    }
}
