// https://leetcode.com/problems/coin-change-ii/
// Approach: Similar to Coin Change I
// Optimize space using 1D array
// Time: O(coins.length * amount)
// Space: O(amount)
class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1; // one way to make the amount = 0 with zero coins (not choose)
        for (int column = 1; column <= amount; column ++) {
            // There are zero ways to make the amount > 0 with zero coins.
            dp[column] = 0;
        }
        for (int row = 1; row <= coins.length; row ++) {
            for (int column = 0; column <= amount; column ++) {
                if (coins[row - 1] <= column) { // Denomation should be greater than or equal to amount
                    dp[column] = dp[column] + dp[column - coins[row - 1]]; // Total number of ways
                }
            }
        }
        return dp[amount];
    }
}