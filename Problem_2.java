// Coin Change II
// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No, but have a confusion about j


// Approach
// As there are repeated sub-problems, will consider DP and as types of coin, amount variable, so consider a matrix.
// Here we are calculating total number of ways. So for each cell will find how many number of ways are there to make a certain amount.
// Then for zero case, see the previous row's column OR sum of column of previous row and current row denominations step back

class Solution {
    public int change(int amount, int[] coins) {
        if(coins == null)
            return 0;

        int n = amount;
        int m = coins.length;
        int [][]dp = new int[m+1][n+1];
        dp[0][0] = 1;

        for(int i = 1; i <= m; i++) {
            dp[i][0] = 1;
        }
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                //zero case
                if(j < coins[i-1]) {
                    dp[i][j] = dp[i-1][j];
                }
                else { //sum of column of previous row and current row denominations step back
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
                }
            }
        }
        return dp[m][n];
    }
}