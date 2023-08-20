# Time Complexity : O(n*amount)
# Space Complexity :O(n*amount)
# Passed on Leetcode: yes

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:

        nCoins = len(coins)
        dp = [[None for _ in range(amount+1)] for _ in range(nCoins+1)]
        
        for i in range(1, amount+1):
            dp[0][i] = 0
        for i in range(nCoins+1):
            dp[i][0] = 1
        
        for i in range(1, nCoins+1):
            for j in range(1, amount+1):
                if coins[i-1] > j:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]

        return dp[nCoins][amount]
        