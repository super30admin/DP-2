// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
public class Solution {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;
        int n = costs.length;
        // Itterate over each row from second row (in a top down approach) and calculate the minimum cost for each color
        for (int i = 1; i < n; i++) {
            // Add the minimum cost between the other 2 colors from the previous cases
            costs[i][0] += Math.min(costs[i - 1][1], costs[i - 1][2]);
            costs[i][1] += Math.min(costs[i - 1][0], costs[i - 1][2]);
            costs[i][2] += Math.min(costs[i - 1][0], costs[i - 1][1]);
        }

        //Return the minimum value from the final row
        return Math.min(Math.min(costs[n - 1][0], costs[n - 1][1]), costs[n - 1][2]);
    }
}