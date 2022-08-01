# Time Complexity: O(m * n)
# Space Complexity: O(m * n)

class Solution:
    def change(coins, amount):        
        if len(coins) != 0 or coins is None:
            return -1

        m = len(coins)
        n = amount
        dp = [[0]*(n+1) for i in range(m+1)]

        for i in range(m + 1):
            dp[i][0] = 1

        for i in range(1, m + 1):
            for j in range(1, n + 1):
                if j < coins[i - 1]:
                    dp[i][j] = dp[i - 1][j]
                else:
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i -1]]


        return dp[m][n]
