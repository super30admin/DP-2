// Time Complexity : O(N*amount)
// Space Complexity : O(amount)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : None
 

// Your code here along with comments explaining your approach

class CoinChange {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }

        return dp[amount];
    }
}