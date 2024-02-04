//Time Complexity - O(n))
//Space Complexity - O(1)
//Ran in Leetcode - Yes

public class CoinChange_All_possible_ways_DP {
	public static int coinChange(int[] coins, int amount) {
		int column = amount + 1;
		int[] dp = new int[column];
		dp[0] = 1;
		for (int r = 0; r < coins.length; r++) {
			for (int c = 0; c < column; c++) {
				if (c < coins[r])
					dp[c] = dp[c];
				else
					dp[c] = dp[c] + dp[c - coins[r]];
			}
		}
		return dp[column - 1];
	}


public static void main(String[] args) {
	// TODO Auto-generated method stub
	int[] nums = { 1, 2, 5 };
	int amount = 11;
	int output = coinChange(nums, amount);
	System.out.println(output);
}

}