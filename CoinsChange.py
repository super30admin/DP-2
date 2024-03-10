# TC = O(mn)
# SC O(mn)
# Where m is amount and n is length of coins
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        m = amount + 1
        n = len(coins) + 1
        dp = [[0 for _ in range(m)] for _ in range(n)]
        dp[0][0] = 1

        for i in range(1, n):
            for j in range(m):
                if j < coins[i - 1]:
                    dp[i][j] = dp[i - 1][j]
                else:
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]]

        return dp[n - 1][m - 1]
