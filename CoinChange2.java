class Solution {
    // Time Complexity : O(mn), where m is the no of different coin denominations and n is amount to be formed from them.
    // Space Complexity : O(mn)
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No

    public int change(int amount, int[] coins) {
        return helper(amount, coins, 0);
    }

    public int helper(int amount, int[] coins, int index) {
        int[][] dp = new int[coins.length+1][amount+1];
        int r = dp.length;
        int c = dp[0].length;
        for(int i = 0; i < r; i++) {
            dp[i][0] = 1;
        }
        for(int i = 1; i < r; i++) {
            for(int j = 1; j < c; j++) {
                if(j < coins[i-1]) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[r-1][c-1];
    }
}