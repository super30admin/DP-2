#TC : O(len(coins)*amount)
#SC : O(amount)
class Solution(object):
    def change(self, amount, coins):
        """
        :type amount: int
        :type coins: List[int]
        :rtype: int
        """
        dp = [0] * (amount + 1)
        dp[0] = 1
        for i in coins:
            for j in range(i, amount + 1):
                   dp[j] += dp[j - i]
        return dp[amount]