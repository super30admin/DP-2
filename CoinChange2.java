// Time Complexity :  O(MN), M-> number of coins, N-> amount
// Space Complexity : O(MN), M-> number of coins, N-> amount
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

public class CoinChange2{
	
	public int getChange(int[] coins,int amount) {
		    
            //checking whether the coins input array is empty or not
			if(coins == null) {
				return 0;
			}
			
			int rows = coins.length+1;
			int cols = amount+1;
			int[][] dp = new int[rows][cols];
			
            //assigning 1 to the first column
			for(int i=0;i<rows;i++) {
				dp[i][0]=1;
			}
			
            //filling the array by adding the value in previous row and same column to the value at the index we get by subtracting the amount and coin at same row
			for(int i=1;i<rows;i++) {
				for(int j=1;j<cols;j++) {
					if(j<coins[i-1]) {
						dp[i][j] = dp[i-1][j];
					}else {
						dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
					}
				}
			}

            //finally returning the value at last row and last-column
			return dp[rows-1][cols-1];
		
	}
	
	public static void main(String[] args) {
		CoinChange2 o = new CoinChange2();
		int[] coins = {1,2,5};
		int amount = 5;
		
		System.out.println(o.getChange(coins,amount));
		
	}
}