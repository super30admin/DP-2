# Implementation : Build a 2D DP table where dp[i][j] = number of ways to make amount j using coins[i:].
# Time Complexity: O(n * amount), where n = len(coins), since we fill an (n+1)×(amount+1) table.
# Space Complexity: O(n * amount), due to the dp table of size (n+1) × (amount+1).


class Solution(object):
    def change(self, amount, coins):
        """
        :type amount: int
        :type coins: List[int]
        :rtype: int
        """
        n = len(coins)
        dp = [[0] * (amount + 1) for _ in range(n + 1)]
        for i in range(n):
            dp[i][0] = 1

        for i in range(n - 1, -1, -1):
            for j in range(1, amount + 1):
                if coins[i] > j:
                    dp[i][j] = dp[i + 1][j]
                else:
                    dp[i][j] = dp[i + 1][j] + dp[i][j - coins[i]]
        return dp[0][amount]