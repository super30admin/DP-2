//Space complexity has been reduced to O(n) than using array

// Time Complexity : O(n) // n is total number of houses
// Space Complexity : O(mxn) // here 3 color so O(n) else it is m x n : m colors choices with n houses to paint.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Learning DP. Able to solve after watching class recording twice. Needs help.

/*
    We are starting building bottom up tree by making new matrix.
    Calculate minimum at each row and column level. Go to all the way up. At end, minimum of all columns of first 3 rows is our minimum cost to paint house.

    It is good Dynamic program pattern to learn.
*/
public class CoinChangeNoOfWaysUsngArr {
    public int change(int amount, int[] coins) {
        if (coins == null || coins.length == 0)
            return 0;

        int n = coins.length;
        int m = amount;
        int[] dp = new int[m + 1];
        dp[0] = 1;

        for (int j = 1; j <= m; j++) {
            dp[j] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (j < coins[i - 1]) {
                    dp[j] = dp[j];
                } else {
                    dp[j] = dp[j] + dp[j - coins[i - 1]];
                }
            }
        }

        return dp[m];
    }
}