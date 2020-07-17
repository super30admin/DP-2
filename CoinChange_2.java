// Time Complexity : O(n*T);  n is the number of coins and T is the target
// Space Complexity : O(n*T)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*Using Dynamic Programming
 * */


public class CoinChange_2 {
	public static int change(int amount, int[] coins) {
		int[][] dp = new int[coins.length+1][amount+1];
		
		for(int i=0; i<=coins.length; i++)		
			dp[i][0] = 1;
		
		for(int j=1; j<=amount; j++)
			dp[0][j] = 0;
		
		for(int i=1; i<=coins.length; i++) {
			for(int j=1; j<=amount; j++) {
				if(coins[i-1] > j)			// if coin value is greater than the amount, then copy the previous row value
					dp[i][j] = dp[i-1][j];
				
				else		// else, consider the case as exclude the coin, include the coin and add both
					dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
			}
		}
		return dp[coins.length][amount];
	}

	public static void main(String[] args) {
		int[] coins = {1, 2, 5};
		int amount = 5;
		System.out.print(change(amount, coins));
	}
}
