// Time Complexity : O(m*n) where m is the number of coins and n is the amount
// Space Complexity :O(n) where n is the amount
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

// Your code here along with comments explaining your approach
class Solution {
    public int change(int amount, int[] coins) {
        if (coins == null || coins.length == 0)
            return 0;
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                // when amount>=denomination
                if (j >= coins[i])
                    // add the number of ways using the previous denomiantion and current
                    // denomination
                    dp[j] = dp[j] + dp[j - coins[i]];
            }
        }
        return dp[amount];
    }
}