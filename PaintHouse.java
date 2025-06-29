// Time Complexity : O(n) where n is number of houses
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Had to revise basic syntax

// ## Problem1(https://leetcode.com/problems/paint-house/)
// There is a row of n houses, where each house can be painted one of three colors: red, blue, or green. The cost of painting each house with a certain color is different.
// You have to paint all the houses such that no two adjacent houses have the same color.
// The cost of painting each house with a certain color is represented by an n x 3 cost matrix costs.
// For example, costs[0][0] is the cost of painting house 0 with the color red; costs[1][2] is the cost of painting house 1 with color green, and so on...
// Return the minimum cost to paint all houses.

// Example:
// Input: costs = [[17,2,17],[16,16,5],[14,3,19]]
// Output: 10
// Explanation: Paint house 0 into blue, paint house 1 into green, paint house 2 into blue.
// Minimum cost: 2 + 5 + 3 = 10.

// Constraints:
// costs.length == n
// costs[i].length == 3
// 1 <= n <= 100
// 1 <= costs[i][j] <= 20

class Solution {
    public int minCost(int[][] costs) {
        // Base case: If no houses, no cost
        if (costs == null || costs.length == 0){
            return 0;
        }
        int n = costs.length;
        // Starting from the second-last row and moving upwards
        for (int i = n - 2; i >= 0; i--){
            // If we paint current house with color 0 (red), adding cost of painting next house with color 1 or 2 (min of those)
            costs[i][0] = costs[i][0] + Math.min(costs[i + 1][1], costs[i + 1][2]);

            // If we paint current house with color 1 (blue), adding cost of painting next house with color 0 or 2 (min of those)
            costs[i][1] = costs[i][1] + Math.min(costs[i + 1][0], costs[i + 1][2]);

            // If we paint current house with color 2 (green), adding cost of painting next house with color 1 or 0 (min of those)
            costs[i][2] = costs[i][2] + Math.min(costs[i + 1][1], costs[i + 1][0]);
        }

        // Minimum of painting the first house with any of the 3 colors gives the final answer
        return Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2]));
    }
}