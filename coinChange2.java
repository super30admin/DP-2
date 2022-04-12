/**
Problem: coin change 2
https://leetcode.com/problems/coin-change-2/

TC: O(c * amount) where c = number of coins
SC: O(amount)
*/
class Solution {
    public int change(int amount, int[] coins) {
        if (amount == 0) {
            return 1;
        }
        
        if (coins == null || coins.length == 0) {
            return 0;
        }
        
        int dp[] = new int[amount + 1];
        dp[0] = 1;
        
        for (int coin : coins) {
            for (int i = coin; i <= amount; ++i) {
                dp[i] = dp[i] + dp[i-coin];
            }
        }
        return dp[amount];
    }
}