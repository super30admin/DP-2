// Time Complexity : O(m*n), where m is no of coins and n is amount
// Space Complexity : O(m*n), where m is no of coins and n is amount
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int change(int amount, int[] coins) {
        if(coins == null)
            return -1;

        int[][] dp = new int[coins.length + 1][amount + 1];
        dp[0][0] = 1;

        // first column fill one
        for(int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }

        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[0].length; j++) {
                // zero case
                // coins[i-1] since in coins we have one less element than value of i could be
                if(j < coins[i-1]) {
                    // from above
                    dp[i][j] = dp[i-1][j];
                } else {
                    // where we add above value and value at that many steps back
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];

    }
}