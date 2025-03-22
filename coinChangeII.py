from typing import List


class Solution:
    # DP approach
    # TC: O(m*n)
    # SC: O(m * n) dp table
    def change(self, amount: int, coins: List[int]) -> int:
        if coins is None or len(coins) == 0:
            return 0

        m = len(coins)
        n = amount
        dp = [[0] * (n + 1) for _ in range(m + 1)]

        for i in range(m + 1):
            dp[i][0] = 1

        for i in range(1, m + 1):
            for j in range(1, n + 1):
                if j < coins[i - 1]:
                    # Only zero case is available
                    dp[i][j] = dp[i - 1][j]
                else:
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]]

        return dp[m][n]

    # Recursive approach:
    # TC: O(2^n) exponential
    # SC: O(amount) recursion stack/tree
    # def change(self, amount: int, coins: List[int]) -> int:
    #     if coins is None or len(coins) == 0:
    #         return 0

    #     return self.helper(coins, amount, 0)

    # def helper(self, coins, amount, index):
    #     # Base cases
    #     if index == len(coins) or amount < 0:
    #         return 0
    #     if amount == 0:
    #         return 1

    #     # Not choose
    #     case1 = self.helper(coins, amount, index + 1)
    #     # Choose
    #     case2 = self.helper(coins, amount - coins[index], index)

    #     return case1 + case2
