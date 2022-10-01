	// Time Complexity : O (n*3)= O(n) n is length costs 
	// space complexity is :  O (n*3)= O(n) 
	// could not check on leetcode sine it is premium problem

	class Solution {
		public int minCost(int[][] costs) {
			if(costs==null || costs.length==0) return 0;
			int n = costs.length;
			int[][] dp = new int[n][3];
			dp[0][1]= nums[0];
			for(int j =0;i<3;j++){
				
				dp[n-1][j]= costs[n-1][j];
			}
			for(int i=n-1;i>=0;i--){
				dp[i][0]= costs[i][0]+Math.min(dp[i+1][1], dp[i+1][2]);
				dp[i][1]= costs[i][1]+Math.min(dp[i+1][0], dp[i+1][2]);
				dp[i][2]= costs[i][2]+Math.min(dp[i+1][2], dp[i+1][0]);
				
			}
			int min =Integer.MAX_VALUE;
			for(int j=0;j<2;j++){
				min= Math.min(min,dp[0][j]);
			}
			return min;
			
		}
	}