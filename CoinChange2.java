package Oct24;

class CoinChange2 {
    public int change(int amount, int[] coins) {   
        
    // Time Complexity: O(mn) where m is no.of elements in the coins array and n is target amount. 
	// Because we are traversing the dp 2-d array once completely across all m rows and n columns.

	// Space Complexity: O(mn) where m is no.of elements in the coins array and n is target amount. 
	// Because we are forming dp grid of (m+1)*(n+1) elements.
	        
	// Did this code successfully run on Leetcode : Yes

	// Any problem you faced while coding this : No

	// Approach: 
	// Recursive approach fails with large input.
	// So going for DP,since recursive tree shows that there are repeated sub-problems.
        
        // edge case
        if (amount == 0) {
            return 1;
        }
        
        return helper(coins, amount);
    }
    
    // DP function
    public int helper(int[] coins, int amount) {
        
        // Initializing dp array with rows=coins array size+1 and cols =amount+1
        int rows = coins.length+1;
        int cols = amount+1;
        int[][] dp = new int[rows][cols];
        
        // Initializing first column of dp array with 1 since there is 1 way always to make 0 amount with any no.of coins
        // We need not initialize first row of dp array because first row of dp array should be 0 as we cannot make any amount with only coins of denomination 0. 
        for (int i = 0; i < rows; i++) {
            dp[i][0] = 1;
        }
        
        // At any point, dp[i][j] denotes the total number of ways in which amount j can be made using coins of denomination from 0 to i index in coins array.
        // Populate dp array using the formula:
        // CASE1: If amount >= highest denomination coin in given array:
        //        dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
        // CASE2: If amount < highest denomination coin in given array:
        //        dp[i][j] = dp[i-1][j];
        
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (j < coins[i-1]) {
                    dp[i][j] = dp[i-1][j];
                } 
                else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }
        
        return dp[rows-1][cols-1];
        
    }
}