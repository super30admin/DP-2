class Solution {
    public int change(int amount, int[] coins) {
        
        return dp_coin_imp(amount, coins);
    }
    
    public int dp_coin_imp(int amount, int[] coins) {
        
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        
        for (int i = 0; i < coins.length; i++) {
            int coin = coins[i];
            for (int j = coin; j < amount + 1; j++) {
                dp[j] += dp[j - coin];
            }
        }
        return dp[amount];
    }
}
//Runtime: O(coins.length * amount)
//Space: O(amount)