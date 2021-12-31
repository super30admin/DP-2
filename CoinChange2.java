package dp2;

public class CoinChange2 {
	//Time Complexity : O(m*n), where m is the length of array coins and n is amount
	//Space Complexity : O(n), where n is the amount
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : Used yesterday's technique from class
	public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        
        for(int i=0; i<coins.length; i++) {
            for(int j=1; j<amount + 1; j++) {
                if(j >= coins[i])
                    dp[j] = dp[j] + dp[j - coins[i]];
            }
        }
        
        return dp[amount];
	}
	
	//DP
	//Time Complexity - O(m*n)
	//Space Complexity - O(m*n)
	public int change1(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        dp[0][0] = 1;
        
        for(int i=1; i<coins.length + 1; i++) {
            for(int j=0; j<amount + 1; j++) {
                if(j >= coins[i - 1]) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        return dp[coins.length][amount];
    }
	
	//Recursion
	//Time Complexity(2^n) - TLE
	int count = 0;
    public int change2(int amount, int[] coins) {
        helper(amount, coins, 0);
        return count;
    }
    
    private void helper(int amount, int[] coins, int index) {
        //base
        if(amount == 0) {
            count += 1;
            return;
        }
        
        if(amount < 0 || index == coins.length)
            return;
        
        //logic
        //choose
        helper(amount - coins[index], coins, index);
        
        //don't choose
        helper(amount, coins, index + 1);
    }
}
