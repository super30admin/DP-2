# Time Complexity : - O(N*amount)
# Space Complexity : O(N)

# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No, basically i took help from previos solution of coin change

class Solution:
    def change(self, amount: int, coins) -> int:
        dp = [0] * (amount + 1)
        dp[0] = 1
        
        for coin in coins:
            for x in range(coin, amount + 1):
                dp[x] += dp[x - coin]
        return dp[amount]