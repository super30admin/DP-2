// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
/*
We intiially try to fill the zeroth column for all coins as 1 as they lead to happy path scenario where
the net amount is 0. Now, for every coin and amount combination, we consider choose and no choose scenario
sum. For no choose, the value of cell obtains directly from above cell.For choose scenario, we get it from
same row and column belonging to amount and coin denomination difference.
 */

class Solution {
    public int change(int amount, int[] coins) {
        int m = coins.length;
        int n = amount;

        int[][] dp = new int[m + 1][n + 1];

        for(int i = 0 ; i <= m ; i++)
            dp[i][0] = 1;

        for(int i = 1 ; i <= m ; i++) {
            for(int j = 1 ; j <= n ; j++) {
                if(j < coins[i - 1])
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
            }
        }
        return dp[m][n];
    }
}