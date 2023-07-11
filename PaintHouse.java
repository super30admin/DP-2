// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class PaintHouse {
    public int minCost(int[][] costs) {
        int n = costs.length; // Number of houses

        if (n == 0) {
            return 0; // If there are no houses, the cost is 0
        }

        // Iterate through each house starting from the second house
        for (int i = 1; i < n; i++) {
            // Update the cost of painting each house with the minimum cost of painting the previous house with a different color
            costs[i][0] += Math.min(costs[i - 1][1], costs[i - 1][2]);
            costs[i][1] += Math.min(costs[i - 1][0], costs[i - 1][2]);
            costs[i][2] += Math.min(costs[i - 1][0], costs[i - 1][1]);
        }

        // Find the minimum cost among the last row (costs of painting the last house)
        return Math.min(Math.min(costs[n - 1][0], costs[n - 1][1]), costs[n - 1][2]);
    }
}
