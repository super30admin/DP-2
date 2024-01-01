// Time Complexity : O(M * N)
// Space Complexity :O(M * N)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


class Solution {
public:
    int change(int amount, vector<int>& coins) {
         int m = coins.size();
        int n = amount;

      
        vector<vector<int>> dp(m + 1, vector<int>(n + 1, 0));
         // There is one way to make amount 0, which is by not selecting any coin
        dp[0][0] = 1;

        for (int i = 1; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                // If the current coin value is less than or equal to the amount,
                // we can either exclude it (dp[i-1][j]) or include it (dp[i][j-coins[i-1]])
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                 // If the current coin is too large to be included, exclude it
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }
        // The final result is stored in dp[m][amount]
        return dp[m][n];
    }
};