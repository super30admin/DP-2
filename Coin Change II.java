// Time Complexity: O(m * n)
// Space Complexity: O(m * n) m and n are matrix indexes
class Solution {
    public int change(int amount, int[] coins) {
        int [][]dp = new int[coins.length + 1][amount+1];
        dp[0][0] = 1;

        for (int i = 1; i <= coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }
        return dp[coins.length][amount];
    }
}