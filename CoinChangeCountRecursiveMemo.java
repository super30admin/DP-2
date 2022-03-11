/**
 * Time complexity is O(n*k)
 * space complexity is O(n*k)
 */

class Solution {
    Integer[][] dp;
    public int change(int amount, int[] coins) {
        dp = new Integer[coins.length][amount+1];
        int res = coinChange(coins, amount, 0);
        return res == Integer.MAX_VALUE ? -1 : res;
    }
    private int coinChange(int[] coins, int amount, int i) {
        if(amount < 0 || i >= coins.length) {
            return 0;
        }
        if(amount == 0) {
            return 1;
        }
        if(dp[i][amount] == null) {
            // include coin[i]
            int case1 = coinChange(coins, amount-coins[i], i);
        
            //don't include coin[i]
            int case2 = coinChange(coins, amount, i+1);
            dp[i][amount] = case1 + case2;
        }
        return dp[i][amount];
    }
}