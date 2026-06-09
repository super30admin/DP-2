// Time Complexity : O(m*n) where m is the number of coins and n is the amount
// Space Complexity : O(m*n) where m is the number of coins and n is the amount
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// We can use a top down approach to solve this problem.
// We will start from the first coin and try to take it and then we will move to the next coin and try to take it and so on until we reach the amount 0 or we exceed the amount.
//  We will keep track of the number of ways to make the amount for each coin and each amount in a dp array. 
// Finally, we will return the number of ways to make the amount for the first coin and the given amount.

class Solution {

    int[][] dp;

    public int change(int amount, int[] coins) {

        int m = coins.length;

        dp = new int[m + 1][amount + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= amount; j++) {
                dp[i][j] = -1;
            }
        }

        return helper(coins, amount, 0);
    }

    private int helper(int[] coins, int amount, int index) {

        if (amount == 0) {
            return 1;
        }

        if (index == coins.length || amount < 0) {
            return 0;
        }

        if (dp[index][amount] != -1) {
            return dp[index][amount];
        }

        // Skip current coin
        int case0 = helper(coins, amount, index + 1);

        // Take current coin
        int case1 = helper(coins, amount - coins[index], index);

        dp[index][amount] = case0 + case1;

        return dp[index][amount];
    }
}