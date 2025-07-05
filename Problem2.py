# Time Complexity:
# O(m * n)

# Space Complexity:
# O(m * n)
class Solution(object):
    def change(self, amount, coins):
        """
        :type amount: int
        :type coins: List[int]
        :rtype: int
        """
       
        n = len(coins)
        dp = [[0] * (amount + 1) for _ in range(n + 1)]

        for i in range(n + 1):
            dp[i][0] = 1  # There's 1 way to make amount 0: choose nothing

        for i in range(1, n + 1):  # coins
            for j in range(1, amount + 1):  # amount
                if coins[i - 1] > j:
                    dp[i][j] = dp[i - 1][j]
                else:
                    # Include + exclude the current coin
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]]

        return dp[n][amount]