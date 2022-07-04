//Time Complexity : O(m*n)
//Space Complexity : O(m*n)
//Code run successfully on LeetCode.

public class Problem2_DP {
	
	public int change(int amount, int[] coins) {
        
		if(coins.length ==0 || coins == null)
			return 0;
		
		int m = coins.length;
		int n = amount;
		
		int[][] dp = new int[m+1][n+1];
		
		for(int i =0; i< m+1; i++)
			dp[i][0] = 1;
		
		for(int i =1; i < m+1; i++) {
			for(int j =1; j < n+1; j++) {
				
				if(j < coins[i-1])
					dp[i][j] = dp[i-1][j];
				
                else
				   dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
			}
		}
		
		return dp[m][n];
    }

}
