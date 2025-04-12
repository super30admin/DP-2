//Time Complexity : O(m*n)
// Space Complexity: O(n)
class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int c : coins)
            for (int i = c; i <= amount; i++)
                dp[i] += dp[i - c];
        return dp[amount];
    }
}