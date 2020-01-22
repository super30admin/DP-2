# Runs on Leetcode
  # Runtime - O(m*n)
  # Space - O(m*n). m is number of coins and n is amount

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        if not amount:
            return 1
        
        dp = [[0 for j in range(amount+1)] for i in range(len(coins)+1)]
        
        dp[0][0] = 1
        
        rows = len(dp)
        cols = len(dp[0])
        
        for i in range(1,rows):
            for j in range(cols):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]
                    
        return dp[-1][-1]
