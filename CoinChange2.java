// Time Complexity : O(NM) :: N -> No. of Denominations M :: Amount
// Space Complexity : O(NM)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// This is the Bottom up DP
class CoinChange2 {
    public int change(int amount, int[] coins) {

        if (coins == null || coins.length == 0) return 0;

        // return total number of ways
        int r = coins.length;
        int c = amount;

        int[][] dp = new int[r + 1][c + 1];

        // Initialize first dummy row in dp
        dp[0][0] = 1;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {

                // If amount  < denomination in coins array
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }

            }
        }

        return dp[r][c];

    }
}

//This is Exhaustive approach based on Pick and Non-pick
// Time Complexity : O(2 ^ N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : No -> Getting Time limit exceeded error
/*
class Solution {

    private int helper(int[] coins, int amount, int index) {

        if (amount == 0) return 1;

        if (amount < 0 || index >= coins.length) return 0;

        // pick up the coin
        int i = helper(coins, amount - coins[index], index);

        // Not pickup
        int j = helper(coins, amount, index + 1);

        return i + j;
    }

    public int change(int amount, int[] coins) {

        if (coins == null || coins.length == 0) return 0;

        int index = 0;

        return helper(coins, amount, index);

    }

}
*/