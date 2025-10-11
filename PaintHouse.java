import java.util.Arrays;

/**
 * Leet Code : https://leetcode.com/problems/paint-house/submissions/1798030723/
 *
 * Approach:
 * This solution uses top-down dynamic programming (recursion with memoization) to find the minimum cost to paint all houses
 * such that no two adjacent houses have the same color. Each house can be painted with one of three colors, and the cost for
 * each color is given. We recursively try all colorings for each house, ensuring that no two adjacent houses have the same color.
 *
 * - The memoization table (memo) stores the minimum cost for each house and color combination to avoid redundant calculations.
 * - For each house, we try painting it with each color, and recursively compute the minimum cost for the rest of the houses.
 * - The answer is the minimum cost among the three color choices for the first house.
 *
 * Time Complexity: O(n), where n is the number of houses (since each subproblem is solved only once for each house and color).
 * Space Complexity: O(n) for the memoization table.
 */
public class PaintHouse {

    int[][] memo;

    public int minCost(int[][] costs) {
        memo = new int[costs.length][costs[0].length];
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }
        // Try all three colors for the first house
        int colorR = helper(costs, 0, 0);
        int colorB = helper(costs, 1, 0);
        int colorG = helper(costs, 2, 0);
        return Math.min(colorR, Math.min(colorB, colorG));
    }

    public int helper(int[][] costs, int color, int house) {
        // Base case: all houses painted
        if (house >= costs.length) return 0;

        // Return memoized result if available
        if (memo[house][color] != -1) return memo[house][color];
        int result = 0;
        // Try painting current house with the given color, and recursively paint the next house with a different color
        if (color == 0) { // Red
            int colorB = helper(costs, 1, house + 1) + costs[house][0];
            int colorG = helper(costs, 2, house + 1) + costs[house][0];
            result = Math.min(colorB, colorG);
        } else if (color == 1) { // Blue
            int colorR = helper(costs, 0, house + 1) + costs[house][1];
            int colorG = helper(costs, 2, house + 1) + costs[house][1];
            result = Math.min(colorR, colorG);
        } else { // Green
            int colorR = helper(costs, 0, house + 1) + costs[house][2];
            int colorB = helper(costs, 1, house + 1) + costs[house][2];
            result = Math.min(colorR, colorB);
        }
        // Memoize and return
        memo[house][color] = result;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new PaintHouse().minCost(new int[][]{{17, 2, 17}, {16, 16, 5}, {14, 3, 19}}));
        System.out.println(new PaintHouse().minCost(new int[][]{{17, 2, 17}}));
    }
}
