// Time Complexity : Time coplexity would be O(m * n)
// Space Complexity : Space coplexity would be O(m * n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public int change(int amount, int[] coins) {
        // n is the number of coins. adding one to it for the dummy row
        int n = coins.length + 1;
        // m is the amount and adding 1 to this to include 0
        int m = amount + 1;
        // m*n matrix for storing the number of ways
        int[][] dp = new int[n][m];
        // First element of the the dummy row will be 1 and the remaining will be 0
        dp[0][0] = 1;
        // m * n for loop to traverse over the whole matrix
        for (int i = 1; i < n; i++) {
            // Getiing the value of coin for that row
            int c = coins[i - 1];
            for (int j = 0; j < m; j++) {
                // If amount is less than the coin, get the value from the last row
                if (j < c) {
                    dp[i][j] = dp[i - 1][j];
                }
                // Else get the value from last row and add the value for amount - coin
                else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - c];
                }
            }
        }
        // Get the value of the last element in matrix
        return dp[n - 1][m - 1];
    }
}