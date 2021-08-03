//Time Complexity: O(1)
//Space Complexity: O(amount)
public class Solution {
    public int Change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
            dp[0] = 1;

            foreach (int coin in coins)
            {
                for (int x = coin; x < amount + 1; ++x)
                {
                    dp[x] += dp[x - coin];
                }
            }
            return dp[amount]; 
    }
}