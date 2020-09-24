"""
// Time Complexity : O(N * amount)
// Space Complexity : O(amount)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
"""
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        
        dp = [0] * (amount + 1)
        dp[0] = 1
        for coin in coins:
            for i in range(coin, amount + 1):
                dp[i] = dp[i] + dp[i-coin]
        
        return dp[amount]