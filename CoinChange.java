/**
 * Coin Change 2
 *
 */
public class CoinChange {
	public static int change(int amount, int[] coins) {
		int maxi = coins.length+1;
		int maxj = amount+1;
		int[][] dp = new int[maxi][maxj];
		for(int i=0; i<maxi; i++) {
			dp[i][0] = 1;
		}
		for(int j=1; j<maxj; j++) {
			dp[0][j] = 0;
		}
		for(int i=1; i<maxi; i++) {
			for(int j=1; j<maxj; j++) {
				if(coins[i-1] > j) dp[i][j] = dp[i-1][j];
				else dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
			}
		}
		return dp[maxi-1][maxj-1];
	}
	        
	public static void main(String[] args) {
		int[] coins = {};
		int amount = 0;
		System.out.println(change(amount, coins));
	}
}
