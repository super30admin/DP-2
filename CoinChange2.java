import java.util.*;

// Recursive Exhaustive Approach
// I recursively tred including or skipping each coin to find
// all combinations that sum up to the given amount.
// This leads to overlapping subproblems and exponential time.

// Time Complexity : O(2 ^ (m + n)), where m = coins.length, n = amount
// Space Complexity : O(amount) due to recursive stack depth
// Did this code successfully run on Leetcode : Yes (but slow on large inputs)
// Any problem you faced while coding this : No

class CoinChange2 {
    public int change(int amount, int[] coins) {
        return recursiveHelper(coins, 0, amount);
    }

    private int recursiveHelper(int[] coins, int i, int amount) {
        if (amount < 0 || i == coins.length) return 0;
        if (amount == 0) {
            return 1;
        }
        // case 0: skip the coin
        int case0 = recursiveHelper(coins, i + 1, amount);
        // case 1: choose the coin
        int case1 = recursiveHelper(coins, i, amount - coins[i]);
        return case0 + case1;
    }
}

// 2D DP Approach
// dp[i][j] represents the number of ways to make amount j
// using the first i coins. We either exclude or include
// the current coin and build the table bottom-up.

// Time Complexity : O(m * n), where m = coins.length, n = amount
// Space Complexity : O(m * n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class CoinChange2DP2 {
    public int change(int amount, int[] coins) {
        int m = coins.length;
        int n = amount;
        int[][] dp = new int[m + 1][n + 1];

        dp[0][0] = 1;

        for (int i = 1; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i]];
                }
            }
        }

        return dp[m][n];
    }
}


// 1D DP Optimized Approach
// Space-optimized version of the 2D DP. We use a 1D array
// where dp[j] stores the number of combinations to form j.
// We iterate over coins first to avoid counting duplicates.

// Time Complexity : O(m * n), where m = coins.length, n = amount
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class CoinChange2Optimised {
    public int change(int amount, int[] coins) {
        int m = coins.length;
        int n = amount;
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (coins[i - 1] > j) {
                    dp[j] = dp[j];
                } else {
                    dp[j] = dp[j] + dp[j - coins[i - 1]];
                }
            }
        }

        return dp[n];
    }
}
