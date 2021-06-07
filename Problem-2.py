"""
Same approach case con change 1. Difference is that you are trying to find the total number of paths that lead to a
valid solution.
"""

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        # Approach 1: Top Down
        """
        if amount == 0:
            return 0

        return self.helper(coins, amount, 0)

    def helper(self, coins, amount, index):
        # base
        if amount == 0:
            return 1

        elif amount < 0 or index >= len(coins):
            return 0

        # choose coin at current index
        case0 = self.helper(coins, amount - coins[index], index)

        # do not choose coin at current index
        case1 = self.helper(coins, amount, index+1)

        return case0+case1
        """
        # Approach 2: Top Down with memoization
        if amount == 0:
            return 1

        dp = [[0] * (amount + 1) for _ in coins]

        for i in range(len(dp)):
            dp[i][0] = 1

        for i in range(len(dp)):
            for j in range(len(dp[0])):
                if j < coins[i - 1]:
                    dp[i][j] = dp[i - 1][j]
                else:
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]]

        return dp[-1][-1]


"""
Approach 1:
TC: O(2^n)
SC: O(m)
Approach 2:
TC: O(mn)
SC: O(mn)
"""