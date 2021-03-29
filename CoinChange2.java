// Time Complexity : O(n*amount)
// Space Complexity : O(n * amount)
// n is the length of the coins array
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes
// Coin Change 2


// Your code here along with comments explaining your approach
class Solution {
    public int change(int amount, int[] coins) {
        Integer[][] dp = new Integer[coins.length + 1][amount + 1];
        return coinChange(amount, coins, coins.length, dp);
    }
    public int coinChange(int amount, int [] coins, int n, Integer[][] dp) {
        if(amount == 0) {
            return 1;
        }
        else if(n <= 0) {
            return 0;
        }
        else if(dp[n][amount] != null) {
            return dp[n][amount];
        }
        if(amount >= coins[n-1]) {
            return dp[n][amount] = coinChange(amount-coins[n-1], coins, n, dp) + coinChange(amount, coins, n-1, dp);
        }
        else {
            return dp[n][amount] = coinChange(amount, coins, n-1, dp);
        }
    }
}
