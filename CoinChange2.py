# Please let me know if the time complexity of both the methods(using 2d array and 1 d array) are right...
# I am doubtful.
class Solution(object):
    def change(self, amount, coins):
        """
        :type amount: int
        :type coins: List[int]
        :rtype: int
        """

        # // Time Complexity : O(n * amount) => n is the number of coins
        # // Space Complexity : O(n * amount)
        # // Did this code successfully run on Leetcode : Yes
        # // Any problem you faced while coding this : No
        def twoDimensionalDP():
            coinctr = len(coins) + 1

            ways = [[0 for i in range(amount + 1)] for j in range(coinctr)]

            for j in range(coinctr):
                ways[j][0] = 1

            for i in range(1, coinctr):
                for j in range(1, amount+1):
                    difference = j - coins[i-1]
                    if difference < 0:
                        ways[i][j] = ways[i-1][j]
                    else:
                        ways[i][j] = ways[i-1][j] + ways[i][difference]

            return ways[coinctr-1][amount]

        # // Time Complexity : O(n * amount) => n is the number of coins
        # // Space Complexity : O(amount)
        # // Did this code successfully run on Leetcode : Yes
        # // Any problem you faced while coding this : No

        def oneDimensionalDP():
            change = 0
            ways = [0] * (amount + 1)
            ways[0] = 1

            for coin in coins:
                for amt in range(coin, amount+1):
                    ways[amt] = ways[amt] + ways[amt-coin]

            return ways[amount]

        return oneDimensionalDP()
