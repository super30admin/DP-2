# Time Complexity : O(N+1*A+1) - N no of coins and A is amount
# Space Complexity : O(N+1*A+1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no


class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        dp = [[0 for _ in range(amount+1)] for _ in range(len(coins)+1)]
        for i in range(len(coins)+1):
            dp[i][0] = 1
        for i in range(1, len(coins)+1):
            for j in range(1, amount+1):
                if coins[i-1] <= amount:
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]]
                else:
                    dp[i][j] = dp[i-1][j]
        return dp[len(coins)][amount]