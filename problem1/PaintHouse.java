// Time Complexity : O(n)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem1;

public class PaintHouse {
	public int minCost(int[][] costs) {
		if (costs == null || costs.length == 0) {
			return 0;
		}

		int n = costs.length;

		for (int i = n - 2; i >= 0; i--) {
			costs[i][0] = costs[i][0] + Math.min(costs[i + 1][1], costs[i + 1][2]);
			costs[i][1] = costs[i][1] + Math.min(costs[i + 1][0], costs[i + 1][2]);
			costs[i][2] = costs[i][2] + Math.min(costs[i + 1][0], costs[i + 1][1]);
		}

		return Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2]));
	}

	public static void main(String[] args) {
		PaintHouse obj = new PaintHouse();
		System.out.println("Minimum cost ot paint houses = "
				+ obj.minCost(new int[][] { { 17, 2, 17 }, { 16, 16, 5 }, { 14, 3, 19 } }));
	}

}
