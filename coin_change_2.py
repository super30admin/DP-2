"""
time - o(n)
space - o(n)

"""

from typing import List


class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        dp = [[0] * (amount + 1) for _ in range(len(coins) + 1)]
        for i in range(len(dp)):
            dp[i][0] = 1
        for i in range(1, len(dp)):
            for j in range(1, len(dp[0])):
                coin = coins[i - 1]
                dp[i][j] = dp[i - 1][j]
                if coin <= j:
                    dp[i][j] += dp[i][j - coin]

        return dp[-1][-1]
