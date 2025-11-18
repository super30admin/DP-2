class Solution(object):
    def coinChange(self, coins, amount):
        """
        There are two choices here: either not choosing a coin or choosing a coin and adding 1 to it
        Time complexity O(m*n), space complexity: O(n) where m is length of coin array and n is amount
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        m = len(coins)
        n = amount

        dp = [99999 * (n+1)]
        dp[0] = 0

        for j in range(1, m+1):
            dp[j] = -1
        
        for coin in coins:
            for j in range(1, m+1):
                if j < coin:
                    dp[j] = dp[j]
                else:
                    dp[j] = dp[j] + dp[j - coin]+1
        
        if dp[n]==99999:
            return -1
        else:
            return dp[n]