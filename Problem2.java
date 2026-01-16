
// Time Complexity : O(amount * number of coins)
// Space Complexity : O(amount)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int change(int amount, int[] coins) {
        // dp[i] = number of ways to make amount i
        int[]dp=new int[amount+1];
        // Base case
        dp[0]=1;
        // For each coin
        for (int coin : coins) {
            for (int i=coin; i<= amount; i++) {
                dp[i]=dp[i]+dp[i-coin];
            }
        }
        return dp[amount];
    }
}