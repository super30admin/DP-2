// Time Complexity : O(mn) where m is the number of coins and n is the amount
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

/*

Approach: Similar to Coin change 1, but instead of using the table for storing
the minimum number of coins needed to make a particular amount, we store the
number of times we've encountered a solution for that particular amount. So the
final amount would be present in the last cell of the table (which is the
amount that we want).

*/

package main

func change(amount int, coins []int) int {
	if len(coins) == 0 {
		return 0
	}
	if amount == 0 {
		return 1
	}

	dp := make([][]int, len(coins)+1)
	for i := range dp {
		dp[i] = make([]int, amount+1)
	}

	// initialize the table with default values for 0 coins and 0 amount
	for i := 0; i <= len(coins); i++ { // amount 0 (1st column)
		dp[i][0] = 1 // always only 1 combo that gives amount 0
	}

	for j := 1; j <= amount; j++ { // coin denomination 0 (1st row)
		dp[0][j] = 0 // with a coin 0 we can only make use it 0 times
	}

	for i := 1; i <= len(coins); i++ { // for all coins
		for j := 1; j <= amount; j++ { // for all amounts
			if coins[i-1] > j { // in this case, this coin can never make that amount
				dp[i][j] = dp[i-1][j] // so select previous ans
			} else {
				// sum of "don't choose" and "choose" paths
				dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]
			}
		}
	}

	return dp[len(coins)][amount]
}
