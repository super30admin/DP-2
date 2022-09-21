//B-F solution
//TC & SC - exponential
class solution
{
	private int paint(int[][] costs)
	{
		if(costs ==null || costs.length ==0) return -1;
		
		//red -0, gren-1, blue -2
		
		int caseR = helper(costs, 0, 0, 0);
		int caseG = helper(costs, 0, 1, 0);
		int caseB = helper(costs, 0, 2, 0);
		
		return Math.min(caseR, Math.min(caseG, caseB));
	}
	
	private int helper(int[][] costs, int index, int color, int amount)
	{
		//base case 
		if(index == costs.length) return amount;
		if(color == 0) //red used
		{
			amount = amount + costs[index][0];
			return Math.min(helper(costs, index+1, 1, amount), helper(costs, index+1, 2, amount));
		}
		if(color == 1) //green used
		{
			amount = amount + costs[index][1];
			return Math.min(helper(costs, index+1, 0, amount), helper(costs, index+1, 2, amount));
		}
		if(color ==2)
		{
			amount = amount + costs[index][2];
			return Math.min(helper(costs, index+1, 0, amount), helper(costs, index+1, 1, amount));
		}
		return 456423;
	}
}


//Optimized approach - DP
// update the second last row based on the min color
//assume not allowed to mutate the matrix, so take new dp matrix/ 
//TC -- Iterate over costs array, m= number of house, n = 3 colors --> O(m*n) --> O(m*3) --> O(m)
//SC - new matrix of length m*n --> m*3 , O(m);

class solution
{
	private int paint(int[][] costs)
	{
			if(costs ==null || costs.length ==0) return 0;
			int n = costs.length;
			int[][] dp = new int[n][3];
			
			//filling last row as it is, 
			for(int j=0; j<3; j++)
			{
				dp[n-1][j] = costs[n-1][j];
			}
			for(int i = n-2 ; i>=0; i--)
			{
				dp[i][0] = Math.min(dp[i+1][1], dp[i+1][2]);
				
				dp[i][1] = Math.min(dp[i+1][0], dp[i+1][2])
				
				dp[i][2] = Math.min(dp[i+1][0], dp[i+1][1]);
			}
			return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
	}
}