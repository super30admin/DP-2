// Time Complexity : O(n) where n is length of given array/number of houses
// Space Complexity : O(n) where n is length of given array/number of houses because DP array
// Did this code successfully run on Leetcode : Could not check this being a premium question
// Any problem you faced while coding this : No 

class PaintHouse {
	public int minCost(int[][] costs) {
		int n = costs.length; //taking the number of rows
		//using number of rows stored inside n to create the same row count for dp 2d array

		if(costs == null || costs.length = 0) {
			return 0;
		}

		int[][] dp = new int[n][3]; //declaring dp  with same size

		dp[0][0] = costs[0][0]; //initializing the first row with exact same elements as costs first row
		dp[0][1] = costs[0][1];
		dp[0][2] = costs[0][2];

		for(int i=1; i<=costs.length-1; i++) { //starting the loops from 1 because 0th row is filled running till the length - 1
			//taking current row value and adding minimum of rest two colored houses from previous rows
			dp[i][0] = costs[i][0] + Math.min(dp[i-1][1] + dp[i-1][2]);
			dp[i][1] = costs[i][1] + Math.min(dp[i-1][0] + dp[i-1][2]);
			dp[i][2] = costs[i][2] + Math.min(dp[i-1][0] + dp[i-1][1]);
		}

		int res = Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2]));
		//int resInt = Integer.parseInt(res);

		return res;
	}
}