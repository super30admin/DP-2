/**
Time Complexity : O(n^2)
Space Complexity : O(n*m)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
*/

class Solution {
    /**
    Approach:
    - Initialize a 2-D matrix for the dp array.
    - Each row represents the coins array, column represents the amount.
    - Each cell represents the number of ways we can achieve the sum at that point.
    - If amount at j < coins[i-1], we just copy the value from the row above.
      Else, we compute dp[i-1][j] + dp[i][j - coins[i-1]]
    */
    public int change(int amount, int[] coins) {
        int n = coins.length + 1;
        int m = amount + 1;
        
        int[][] dp = new int[n][m];
        
        for(int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        for(int j = 1; j < m; j++) {
            dp[0][j] = 0;
        }
        for(int i = 1; i < n; i++) {
            for(int j = 1; j < m; j++) {
                if(j < coins[i-1]) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
                }
            }
        }
        return dp[n-1][m-1];
    }
}
