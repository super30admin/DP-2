/**
 * Tabulation - bottom-up approach
 * TC: O(m+n) as they are 2 deciding factors
 * SC: O(m+n) 2D matrix
 */
public class CoinChangeIIDP {
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
                    //don't choose + choose
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }
        return dp[m][n];
    }
}

//Approach - 2
class Solution {
    public int change(int amount, int[] coins) {
        int m = coins.length;
        int n = amount;

        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (j < coins[i - 1]) {
                    dp[j] = dp[j];
                } else {
                    //don't choose + choose
                    dp[j] = dp[j] + dp[j - coins[i-1]];
                }
            }
        }
        return dp[n];
    }
}

/**
 * Tabulation - bottom-up approach
 * TC: O(m+n) as they are 2 deciding factors
 * SC: O(n) 1D Array
 */