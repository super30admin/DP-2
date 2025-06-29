// Time Complexity : O(m * n) where m is number of coins and n is the amount
// Space Complexity : O(m * n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Had to revise basic syntax

// ## Problem2 (https://leetcode.com/problems/coin-change-2/)
// You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
// Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.
// You may assume that you have an infinite number of each kind of coin.
// The answer is guaranteed to fit into a signed 32-bit integer.

// Example:
// Input: amount = 5, coins = [1,2,5]
// Output: 4
// Explanation: there are four ways to make up the amount:
// 5=5
// 5=2+2+1
// 5=2+1+1+1
// 5=1+1+1+1+1

// Constraints:
// 1 <= coins.length <= 300
// 1 <= coins[i] <= 5000
// All the values of coins are unique.
// 0 <= amount <= 5000

class Solution {
    public int change(int amount, int[] coins) {
        // Base case : coins array is null or empty
        if (coins == null || coins.length == 0){
            return 0;
        }

        // Creating a 2D DP table with dimensions : (number of coins + 1) * (amount + 1)
        int[][] dp = new int[coins.length + 1][amount + 1];
        for(int i = 0; i < coins.length + 1; i++){
            dp[i][0] = 1;
        }

        // Filling the 2D table
        for(int i = 1; i < coins.length + 1; i++){
            for(int j = 1; j < amount + 1; j++){
                if(j < coins[i - 1]){
                    dp[i][j] = dp[i - 1][j]; // If coin value is greater than current amount
                }
                else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }
        // Result is at last row - last column
        return dp[coins.length][amount];
    }
}
