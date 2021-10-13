"""
Time Compelxity: O(n)
Space Complexity: O(n)
"""

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        # dp matrix
        # columns = amount, rows = columns
        dp = [[None] * (amount + 1) for n in range(len(coins) + 1)]

        # fill the 0th row and 0th column

        # fill the first column
        for i in range(len(dp)):
            dp[i][0] = 1

        for i in range(len(dp[0])):
            dp[0][i] = 0

        for i in range(1, len(dp)):
            for j in range(1, len(dp[0])):
                if coins[i - 1] > j:
                    dp[i][j] = dp[i - 1][j]
                else:
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]]

        result = dp[len(dp) - 1][len(dp[0]) - 1]
        return result
