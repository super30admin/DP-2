//Time Complexity : O(M X N)
//Space Complexity : O(1)
//Code run successfully on LeetCode.

public class Solution {
	public int minCost(int[][] costs) {

		if(costs == null|| costs.length == 0)
			return -1;

		int m = costs.length;
		int n = costs[0].length;
		for(int i = m-2; i >=0; i--) {
			for(int j=0; j < n; j++) {
				if(j == 0) {
					costs[i][j] = Math.min(costs[i][j] + costs[i+1][j+1], costs[i][j] + costs[i+1][j+2]);
				}
				if(j == 1) {
					costs[i][j] = Math.min(costs[i][j] + costs[i+1][j-1], costs[i][j] + costs[i+1][j+1]);
				}
				if(j == 2) {
					costs[i][j] = Math.min(costs[i][j] + costs[i+1][j-1], costs[i][j] + costs[i+1][j-2]);
				}
			}
		}
		return Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2]));
    }

}