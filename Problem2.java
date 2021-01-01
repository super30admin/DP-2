//https://leetcode.com/problems/coin-change-2/

class Solution {

    // Time Complexity : N(amount*coins)
    // Space Complexity : N(amount*coins)
    // Did this code successfully run on Leetcode : Yes
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        for (int i = 0; i <= n; i++)
            dp[i][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= coins[i - 1])
                    dp[i][j] += dp[i][j - coins[i - 1]];
            }
        }
        return dp[n][amount];
    }

    // Time Complexity : N(amount*coins)
    // Space Complexity : O(1)
    // Did this code successfully run on Leetcode : No(TLE)
    int count = 0;

    public int changeRecursive(int amount, int[] coins) {
        helper(coins, amount, 0);
        return count;
    }

    public void helper(int[] coins, int amount, int index) {
        if (amount == 0) {
            count++;
            return;
        } else if (amount < 0 || index >= coins.length) {
            return;
        }
        helper(coins, amount - coins[index], index);
        helper(coins, amount, index + 1);

    }
}