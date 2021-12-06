// Time Complexity : O(coins.length * amount)
// Space Complexity : O(coins.length * amount)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach

//This problem we have to give the total no.of ways we get the given amount
// This is similar to coin change 1
// Instead of taking the max we have to add the result from the choice where we choose and the choice where we dont choose the coin
class Solution {
    public int change(int amount, int[] coins) {
        if (coins == null || coins.length == 0)
            return 0;
        // return solve(coins, amount, 0);

        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int i = 0; i < coins.length + 1; i++)
            dp[i][0] = 1;
        for (int i = 1; i < coins.length + 1; i++) {
            for (int j = 1; j < amount + 1; j++) {
                if (j < coins[i - 1])
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
            }
        }
        return dp[coins.length][amount];
    }

    // Recursion
    public int solve(int[] coins, int amount, int i) {

        if (amount == 0)
            return 1;
        if (amount < 0 || i == coins.length)
            return 0;

        // logic

        int case1 = solve(coins, amount, i + 1);
        int case2 = solve(coins, amount - coins[i], i);

        return case1 + case2;
    }
}