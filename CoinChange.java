//Time Complexity: O(n*amount) where n = coins.length
//Space Complexity: O(amount)
// Did this code successfully run on Leetcode : Yes

public class CoinChange {
    public int change(int amount, int[] coins) {
        if(coins == null) return 0;
        int[] dp = new int[amount + 1];
        for(int i = 1; i <= coins.length; i++) {
            dp[0] = 1;
            for(int j = 1; j <= amount; j++) {
                if(j >= coins[i-1]) {
                    dp[j] = dp[j] + dp[j - coins[i-1]];
                }
            }
        }
        return dp[amount];
    }
}
