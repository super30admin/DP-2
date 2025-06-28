/*
 * LeetCode Problem: Coin Change II  
 * * Approach 1: Exhaustive Search (Recursive)
 * 1. We can also solve this problem using a recursive approach.
 * 2. The recursive function will explore all combinations of coins to find the number of ways to make the target amount.
 * 3. At each step, we can either include the current coin or skip it.
 * 4. If we reach the target amount, we count it as a valid combination.
 * 5. If we exceed the target amount or run out of coins, we return 0.
 * *  Time Complexity: O(2^n) where n is the number of coins, as we explore all combinations.
 * *  Space Complexity: O(n) for the recursion stack.
 * 
 * * Approach 2: Dynamic Programming
 * 1. We will use a bottom-up dynamic programming approach to solve the problem.
 * 2. We will create a 2D DP array where dp[i][j] represents the number of ways to make amount j using the first i coins.
 * 3. We will initialize the first column of the DP array to 1, as there is one way to make amount 0 (by using no coins).
 * 4. We will iterate through the coins and amounts, updating the DP array based on whether we include the current coin or not.
 * 5. Finally, we will return the value in dp[n][amount], where n is the number of coins and amount is the target amount.
 * *  Time Complexity: O(n * amount) where n is the number of coins and amount is the target amount.
 * *  Space Complexity: O(n * amount) for the DP array.
 
 */
public class CoinChangeII {

    // Approach 1: Exhaustive Search (Recursive)
    public int change(int amount, int[] coins) {
        return helper(coins, amount, 0);
    }

    private int helper(int[] coins, int amount, int index) {
        if (amount == 0) {
            return 1;
        }
        if (index == coins.length || amount < 0) {
            return 0;
        }
        int skip = helper(coins, amount, index + 1);
        int take = helper(coins, amount - coins[index], index);
        return skip + take;
    }

    // Approach 2: Dynamic Programming
    public int change(int amount, int[] coins) {
        if (coins == null || coins.length == 0) {
            return 0;
        }
        int n = coins.length;
        int m = amount;
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }
        return dp[n][m];
    }
}
