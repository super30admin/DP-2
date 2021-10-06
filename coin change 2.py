# TC-O(n*m)
# SC-O(n*m)
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        m = len(coins) + 1
        n = amount + 1
        dp = [[0 for i in range(n)] for j in range(m)]
        for i in range(1, n):
            dp[0][i] = 0
        for j in range(m):
            dp[j][0] = 1
        for i in range(1, m):
            for j in range(1, n):
                if (j < coins[i - 1]):
                    dp[i][j] = dp[i - 1][j]
                else:
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]]
        return dp[m - 1][n - 1]
