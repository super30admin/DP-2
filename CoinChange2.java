// Time Complexity : O(n * amount)
// Space Complexity : O(amount)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Needed to avoid counting duplicate permutations, so coins are processed one by one.

class CoinChange2 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];

        // Base case: There is 1 way to make amount 0
        dp[0] = 1;

        // Process each coin
        for (int i = 1; i <= coins.length; i++) {
            int coin = coins[i - 1];

            // Update ways for all amounts from coin to target amount
            for (int j = coin; j <= amount; j++) {
                dp[j] += dp[j - coin];
            }
        }

        return dp[amount];
    }
}