// Exhaustive recurssive solution
// Time Complexity : O(2^n), n is length of coins array,
// Space Complexity : O(2^n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
class Solution {
    public int change(int amount, int[] coins) {
        // base
        if (coins == null || coins.length == 0)
            return 0;

        return helper(coins, 0, amount);
    }

    private int helper(int[] coins, int index, int amount) {
        // base, if amount is 0, we find 1 path. so return 1.
        if (amount == 0)
            return 1;
        // index out of bound
        if (amount < 0. || index == coins.length)
            return 0;

        // case 1 --> choose
        int case1 = helper(coins, index, amount - coins[index]);

        // case 2 --> not choose
        int case2 = helper(coins, index + 1, amount);

        return case1 + case2;
    }
}

// Time Complexity : O(mn), m is length of coins array, n is the amount range
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
/*
 * The exhaustive recursive solution gave a time limit excess -> reduced the
 * extra calculations by using DP
 */
class Solution {
    public int change(int amount, int[] coins) {

        // base case
        if (coins == null || coins.length == 0)
            return 0;

        int m = coins.length;
        int n = amount;

        // 2D array of size coins and amount
        int[][] dp = new int[m + 1][n + 1];

        // if the amount and coin is 0 return 0, 0 is the dummy coin here.
        dp[0][0] = 1;

        for (int i = 1; i <= m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // denominaion of coin less than amount, we assign it to the value from previous
                // row
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // else, sum up the previous row and new sum after choosing the coin
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }
        return dp[m][n];
    }
}