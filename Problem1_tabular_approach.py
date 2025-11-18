class Solution(object):
    def coinChange(self, coins, amount):
        """
        There are two choices here: either not choosing a coin or choosing a coin and adding 1 to it
        Time complexity O(m*n), space complexity: O(m*n) where m is length of coin array and n is amount
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        m = len(coins)
        n = amount

        dp = [[0] * (n+1) for _ in range(m+1)]


        for j in range(1, m+1):
            dp[0][j] = -1
        
        for i in range(1, n+1):
            for j in range(1, m+1):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]]+1
        
        if dp[m][n]==99999:
            return -1
        else:
            return dp[m][n]