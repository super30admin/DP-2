# Time Complexity : O(n * amount) 
# Space Complexity : O(n * amount)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach:
# Use 2D DP Count ways to make each amount using available coins.
# For every coin, either don’t use it or use it (can reuse many times).

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        dp = [[0 for i in range(amount + 1)] for j in range(len(coins) + 1)]

        for i in range(len(coins) + 1):
            dp[i][0] = 1

        for i in range(1, len(coins) + 1):
            for j in range(amount + 1):
                if j < coins[i - 1]:
                    dp[i][j] = dp[i - 1][j]
                else:
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]]

        return dp[len(coins)][amount]
