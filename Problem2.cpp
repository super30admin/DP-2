   //Time complexity : o(n);
// space compplexity : O(n);
   
    int helper(vector<vector<int> nums) {
	
	int n = nums.size();
	int m = 3
	
	int dp[n][m];
	
	for(int  j=0;j<m;j++) {
		dp[n-1][j] = nums[n-1][j];
	}
	
	for(i = n-2;i>=0;i--) {
		dp[i][0] = nums[i][0] + min(dp[i+1][1],dp[i+1][2]) ;
		dp[i][1] = nums[i][1] + min(dp[i+1][0],dp[i+1][2]) 
		dp[i][2] = nums[i][2] + min(dp[i+1][1],dp[i+1][00]) 
		
	}
	
	return min(dp[0][0],min(dp[0][1],dp[0][2]));
	
}