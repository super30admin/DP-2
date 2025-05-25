/**
 * Approach:
 * - Use bottom-up dynamic programming to calculate the minimum cost to paint all houses.
 * - Each house can be painted with 3 colors: red, blue, or green, with associated costs.
 * - Constraint: No two adjacent houses can be painted with the same color.
 * - For each house starting from the second last to the first:
 *   - Update the cost of painting current house with each color by adding the minimum cost
 *     of painting the next house with a different color.
 * - After updating all houses, the minimum cost to paint all houses will be the minimum of the
 *   three values at costs[0], representing painting the first house with red, blue, or green.
 */

// Time Complexity : O(N), where N is the number of houses
// Space Complexity : O(1), since we modify the input array in place
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;

        int n = costs.length;

        // Bottom-up DP: start from the second-last house and move backwards
        for (int i = n - 2; i >= 0; i--) {
            // Cost to paint current house with red
            costs[i][0] += Math.min(costs[i + 1][1], costs[i + 1][2]);
            // Cost to paint current house with blue
            costs[i][1] += Math.min(costs[i + 1][0], costs[i + 1][2]);
            // Cost to paint current house with green
            costs[i][2] += Math.min(costs[i + 1][0], costs[i + 1][1]);
        }

        // Return the minimum of the three options for the first house
        return Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2]));
    }
}
