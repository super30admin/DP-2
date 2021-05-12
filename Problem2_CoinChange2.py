# Time Complexity: O(mn) where m is the length of coins array, n is the amount
# Space Complexity: O(mn)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

# Solution:

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        if not coins or len(coins) == 0:
            return 0

        # Initialize a 2D array with coin denominations as rows and amount as columns
        rows, cols = len(coins) + 1, amount + 1
        dp = [[0 for y in range(cols)] for x in range(rows)]

        # Initialize first col with 1, since not choosing any coins to form amount 0 is valid
        for i in range(rows):
            dp[i][0] = 1

        # Update the count of valid combinations for every amount
        for i in range(1, rows):
            for j in range(1, cols):
                if coins[i - 1] > j:
                    dp[i][j] = dp[i - 1][j]
                else:
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]]

        return dp[rows - 1][cols - 1]