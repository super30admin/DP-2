//Time complexity - O(n)
// Space complexity - O(n)
// Did you solve on leetcode - yes
//Any issues while solving - No
class Solution {
    public int minCost(int[][] costs) {
        int n = costs.length;
        int[][] memo = new int[n][3];
        
        // Fill memo with -1 to indicate uncomputed states
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        // Try painting first house with each of the 3 colors
        return Math.min(
            helper(costs, 0, 0, memo),
            Math.min(helper(costs, 0, 1, memo),
                     helper(costs, 0, 2, memo))
        );
    }

    private int helper(int[][] costs, int row, int color, int[][] memo) {
        if (row == costs.length) return 0;

        if (memo[row][color] != -1) return memo[row][color];

        int min = Integer.MAX_VALUE;

        for (int c = 0; c < 3; c++) {
            if (c != color) { // can't paint same color as previous
                min = Math.min(min, helper(costs, row + 1, c, memo));
            }
        }

        memo[row][color] = costs[row][color] + min;
        return memo[row][color];
    }
}
