class Solution(object):
    def change(self, amount, coins):
        dp = [[0 for i in range(0, amount+1)] for j in range(0, len(coins)+1)]

        for i in range(0, len(coins)+1):
            dp[i][0] = 1

        for coin in range(1, len(coins)+1):
            for j in range(1, amount+1):
                if coins[coin-1] <= j:
                    dp[coin][j] = dp[coin-1][j] + dp[coin][j - coins[coin-1]]
                else:
                    dp[coin][j] = dp[coin-1][j]

        return dp[-1][-1]
