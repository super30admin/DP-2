// Time complexity: O(n^2)
// Space Complexity: O(amount + 1)
class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
		int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i ++) {
            for (int j = 1; j <= amount; j++) {
                if (coins[i - 1] <= j) {
                    dp[j] = dp[j] + dp[j - coins[i - 1]];
                }
            }
        }
        return dp[amount];
    }
}
