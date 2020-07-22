# Time Complexity : O (n*m) where n is the number of coins, m is the range of target value
# Space Complexity : O (n*m)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No


class Solution:
    def change(self, amount: int, coins: List[int]) -> int:

        # we create a dynamic memory matrix, where in each execution we will refer the previous values
        dpMatrix = [[None for j in range(amount + 1)] for i in range(len(coins) + 1)]

        # the number of ways of getting 0 value from all coins will be 1 way for each coins
        for i in range(len(coins) + 1):
            dpMatrix[i][0] = 1

        # the number of ways of getting range of target value from 0 coin individually will be 0 ways
        for j in range(1, amount + 1):
            dpMatrix[0][j] = 0

        for i in range(1, len(coins) + 1):
            for j in range(1, amount + 1):

                # if current value is less than or equal to the previous coin then number of ways to the value
                # will be using the previous coin ways of getting the value.
                if coins[i - 1] > j:
                    dpMatrix[i][j] = dpMatrix[i - 1][j]

                # else we add the previous coin number of  ways to reach the target value and current coin way to
                # reach  (target - current coin) value plus adding 1 value of current coin.
                else:

                    dpMatrix[i][j] = dpMatrix[i - 1][j] + dpMatrix[i][j - coins[i - 1]]

        return dpMatrix[-1][-1]
