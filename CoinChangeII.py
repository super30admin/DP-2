#Time Complexity: O(n*m)
#Space Complexity: O(n)

class Solution(object):
    def change(self, amount, coins):
        """
        :type amount: int
        :type coins: List[int]
        :rtype: int
        """
        m = len(coins)
        n = amount

        dp = [0] * (n + 1)
        dp[0] = 1

        for coin in coins:
            for j in range(coin, n + 1):
                dp[j] += dp[j - coin]

        return dp[n]
        