
// TC: O(n*m) where n is number of coins and m is the amount
// SC: O(n*m) since we are using 2D array

// We are checking values for each value of amount, can we have corresponding number of coins. If the amount is greater than coin value, we can 
// check if the previous coin value of same row(choosen value selected by having index at j-coins[i-1](amount - previous coin)). We will be adding values
// with the not choosen value which is the previous value in same column dp[i][j-1], Add these 2 we are storing these values in dp table.
// if the amount is not greater than coin denomination, we are taking value from previous value in same column since it represents not chosen value.



public class NoCoins2 {
	
	public int CoinChange2(int[] coins, int amt) {
		
		int[][] dp = new int[coins.length+1][amt+1];
		
		for(int i=1;i<=amt;i++)
			dp[0][i] = 0;
		
		for(int i=0;i<=coins.length;i++)
			dp[i][0] = 1;
		
		
		for(int i=1;i<=coins.length;i++) {
			for(int j=1;j<=amt;j++) {
				
				if(j>=coins[i-1])
				{
					dp[i][j] = dp[i-1][j]+dp[i][j-coins[i-1]];
				}
				else
				{
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		return dp[coins.length][amt];
	}
	
	
	// Answer using single Loop where we are just storing the values of sum of the previous amount and amount at index (amount - coin denomination)) 
	public int CoinChangeOneloop(int[] coins, int amt) {
		
		int[] dp = new int[amt+1];
		dp[0] = 1;
		
		for(int i=0;i<coins.length;i++) {
			for(int j=1;j<=amt;j++) {
				if(j-coins[i]>=0) {	
					dp[j] += dp[j-coins[i]];
				}
			}
		
		}
		return dp[amt];
		
	}
	public static void main(String[] args) {
		
		NoCoins2 nc = new NoCoins2();
		int[] coins = {1, 2, 5};
		System.out.println(nc.CoinChangeOneloop(coins, 5));
	}
	
	

}
