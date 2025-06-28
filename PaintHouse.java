/*
 * LeetCode Problem: 256. Paint House: https://leetcode.com/problems/paint-house/
 * Approach: Dynamic Programming
 * * 1. we will use a bottom-up dynamic programming approach to solve the problem.
 * * 2. We will iterate through the houses in reverse order, calculating the minimum cost to paint each house based on the costs of painting the next house.
 * * 3. For each house, we will update the cost of painting it in each color (Red, Green, Blue) by adding the minimum cost of painting the next house in the other two colors.
 * * 4. Finally, we will return the minimum cost of painting the first house in any color.
 * 
 * * Time Complexity: O(n) where n is the number of houses.
 * * Space Complexity: O(1) since we are modifying the input costs array in place.
 */
public class PaintHouse {

    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }

       int n = costs.length;
       for (int i = n - 2; i >= 0; i--) {
            // For each house, calculate the minimum cost to paint it
            costs[i][0] += Math.min(costs[i + 1][1], costs[i + 1][2]); // Red
            costs[i][1] += Math.min(costs[i + 1][0], costs[i + 1][2]); // Green
            costs[i][2] += Math.min(costs[i + 1][0], costs[i + 1][1]); // Blue
        }

        // The result is the minimum cost to paint the first house
        return Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2]));
    }    
}
