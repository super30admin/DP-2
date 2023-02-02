// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

// Your code here along with comments explaining your approach

/**
 * To find the minimum cost, keep the first 3 houses painting cost as it is.
 * then for each row, add the minimum of the other two houses paints costs from
 * previous row. Taking the minimum of final row will give minimum cost.
 *
 */
class Sample {
	public int minCost(int[][] costs) {
		if (costs == null || costs.length == 0)
			return 0;
		int n = costs.length;
		for (int i = 1; i < n; i++) {
			costs[i][0] += Math.min(costs[i - 1][1], costs[i - 1][2]);
			costs[i][1] += Math.min(costs[i - 1][0], costs[i - 1][2]);
			costs[i][2] += Math.min(costs[i - 1][1], costs[i - 1][0]);
		}

		return Math.min(Math.min(costs[n - 1][0], costs[n - 1][1]), costs[n - 1][2]);
	}
}
