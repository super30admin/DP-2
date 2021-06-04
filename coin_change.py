class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        :m = length of the coins array
        :n = amount
        :Time complexity: O(mn)
        :Space complexity: O(n)
        """
        dp = [0]*(amount+1)
        for i in range(1, amount+1):
            if i in coins:
                dp[i] = 1
                continue
            min_coins = float("inf")
            for coin in coins:
                if i-coin >= 0:
                    min_coins = min(dp[i-coin], min_coins)
            dp[i] = min_coins+1
        if dp[-1] == float("inf"):
            return -1
        return dp[-1]