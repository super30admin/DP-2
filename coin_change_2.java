// Time Complexity :O(n*m) where n is the number of coins and m is the amount
// Space Complexity :O(n*m)
// Did this code successfully run on Leetcode : yes
class Solution {
    public int change(int amount, int[] coins) {
        int n= coins.length;
        int m = amount;
        int[][] dp = new int[n+1][m+1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
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