// Time Complexity : O(coins * amount)
// Space Complexity : O(amount)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class CoinChange2 {
    public int change(int amount, int[] coins) {
        // Create an array to store the number of combinations for each amount
        int[] dp = new int[amount + 1];
        // Initialize the base case: there is one way to make up an amount of 0
        dp[0] = 1;

        // Iterate through each coin
        for (int coin : coins) {
            // Iterate through amounts from coin to target amount
            for (int i = coin; i <= amount; i++) {
                // Update the number of combinations for the current amount
                dp[i] += dp[i - coin];
            }
        }

        // Return the number of combinations for the target amount
        return dp[amount];
    }
}
