// Time Complexity :O(coins*amount)
// Space Complexity :O(amount)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No

// Your code here along with comments explaining your approach
//calculatd the max combinations for all the amounts for every coin
//repeated the same considering the combination s of the previous and 
//the present ones

class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i < amount + 1; i++) {
                dp[i] += dp[i - coin];

            }
        }
        return dp[amount];
    }
}