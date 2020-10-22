# Time Complexity: O(mn) where m is no. of coins, n = amount
# Space Complexity: O(mn)
# Did it run on leetcode: Yes
# Did you face any problems: No
# Approach:
# The recursive approach to solve this problem would be as follows
# - for every coin create a set with the coin(if it doesn't exceed the amount) and recursively process all other coins or
# - create a set without the coin and recursively process remaining coins
# - The result is the sum of both recursive calls
# Use the same recurrence to populate a DP grid
# More comments inline...

class Solution(object):
    def change(self, amount, coins):
        """
        :type amount: int
        :type coins: List[int]
        :rtype: int
        """
        # Edge
        if amount == 0:
            return 1
        if len(coins) == 0:
            return 0

        # Initilize dp table
        dp = [[0 for _ in range(amount+1)] for _ in range(len(coins))]

        # Base Case
        for i in range(len(coins)):
            dp[i][0] = 1

        # Tabulation
        for i in range(len(coins)):
            for j in range(1, amount+1):
                if i > 0:
                    # Exclude current coin
                    dp[i][j] = dp[i-1][j]
                if j - coins[i] >= 0:
                    # Include the current coin if it doesn't exceed the amount
                    dp[i][j] += dp[i][j - coins[i]]

        return dp[-1][-1]
