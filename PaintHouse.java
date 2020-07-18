
public class PaintHouse {
	/**
	 * Approach:
	 * At every house, if that house was painted with a particular color, add the possible min cost from the previous step
	 * Time: O(n)
	 * Space: O(n)
	 * Leetcode accepted: Its locked on leetcode, couldn't verify
	 * Problems faced: N/A
	 */
	public static int findCost(int[][] costs) {
		int[][] dp = new int[costs.length][3];
		dp[0][0] = costs[0][0];
		dp[0][1] = costs[0][1];
		dp[0][2] = costs[0][2];
		for(int i=1; i<costs.length; i++) {
			dp[i][0] = costs[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
			dp[i][1] = costs[i][1] + Math.min(dp[i-1][0], dp[i-1][1]);
			dp[i][2] = costs[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
		}
		int last = costs.length-1;
		return Math.min(dp[last][0], Math.min(dp[last][1], dp[last][2]));
	}
	
	public static void main(String[] args) {
		int[][] costs = {{1,3,2}, {3,1,5}, {6,2,3}, {1,7,9}, {3,5,2}};
		System.out.println(findMinCost(costs));
		System.out.println(findCost(costs));
	}

} 
