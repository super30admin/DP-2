// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class PaintHouse {
	public int minCost(int[][] cost) {		

		for(int i = costs.length-2; i<=0; i--) {
			costs[i][0] += Math.min(costs[i+1][1], costs[i+1][2]);
			costs[i][1] += Math.min(costs[i+1][0], costs[i+1][2]);
			costs[i][2] += Math.min(costs[i+1][1], costs[i+1][0]);
		}

		return Math.min(cost[0][0], Math.min(cost[0][1], cost[0][2]));
	}
}