// Time Complexity : O(n * m), where n is number of coins, m is the amount
// Space Complexity : O(n * m)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/* We use dp here. In the 2d dp array rows indicate the coins and columns indicate the 0....amount. Here we add the 2 paths, one 
   when we dont choose the coin dp[i - 1][j] and one when we choose the coin dp[i][j - coins[i - 1]]. All the valid paths are added
   and stored in the corresponding cell of dp array. The final result is stored in dp[n][m] and we return it
*/

class Solution {
    public int change(int amount, int[] coins) {
        if(coins == null || coins.length == 0)
            return 0;

        int n = coins.length;
        int m = amount;

        int[][] dp = new int[n + 1][m + 1];

        dp[0][0] = 1;

        for(int i = 1; i < dp.length; ++i) {
            for(int j = 0; j < dp[0].length; ++j) {
                if(j < coins[i - 1])
                    dp[i][j] = dp[i - 1][j];
                else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }
        return dp[n][m];
    }
}