// Time Complexity: O(n)
// Space complexity: O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int change(int amount, int[] coins) {
        // null
        if(coins == null || coins.length == 0) return 0;
        int m = coins.length;
        int n = amount;
        int[][] dp = new int[m + 1][n + 1];
        // initializing the dummy  as 1 since there is 1 wat to make amount 0, rest are 0 by default
        dp[0][0] = 1;
        for(int i = 1; i < dp.length; i++) {
            for(int j = 0; j < dp[i].length; j++) {
                // j is coin denomination and if it is less take it directly from the above row
                if(j < coins[i - 1]) dp[i][j] = dp[i - 1][j];
                // take the sum, ie total ways from above and from the subproblem in the same row which is amount - coin denomination
                else dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
            }
        }
        return dp[m][n];
    }
}