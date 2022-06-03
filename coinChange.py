# Time complexity: O(m*n)
# Space complexity:O(m*n)
# m is the length of coins
# n is the amount

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        m = len(coins)
        n = amount
        dp = [[0 for i in range(n+1)] for j in range(m+1)]
        
        dp[0][0] = 1
        
        for i in range(1,len(dp)):
            for j in range(len(dp[0])):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j] 
                else:
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]
        return dp[m][n]
        
        
        
        
