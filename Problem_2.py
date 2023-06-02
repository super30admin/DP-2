# Time Complexity: O(coins * amount)
# Space Complexity: O(amount)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

class Solution(object):
    def change(self, amount, coins):
        """
        :type amount: int
        :type coins: List[int]
        :rtype: int
        """
        dp = ([1] + ([0] * amount) + [1])
        for coin in coins:
            for i in range(coin, (amount + 1)):
                dp[i] += dp[(i - coin)]
        return dp[amount]