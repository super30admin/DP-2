# Time Complexity : O(mn)
# Space Complexity : O(mn)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class Solution(object):
    def change(self, amount, coins):
        """
        :type amount: int
        :type coins: List[int]
        :rtype: int
        """
        # creating a matrix of rows as coins and columns as price from 0 to amount
        dp = [[0 for k in range(amount+1)] for k in range(len(coins))]

        # base case where the amount is 0
        for i in range(len(coins)):
            dp[i][0] = 1

        for i in range(len(coins)):

            for j in range(1, amount+1):

                # if the value of current coin greater than the current price, so the values will be the same as previous.

                if coins[i] > j:
                    dp[i][j] = dp[i-1][j]

                # previous coin and current price + the dp value of current coin with (current price - current coin)
                else:
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i]]

        return dp[-1][-1]
