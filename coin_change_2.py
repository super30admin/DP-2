# Time Complexity: o(m*n)
# Space Complexity: o(m*n)

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        m = len(coins)+1
        n = amount+1
        
        dp= [[0]*n]*m
        
        for i in range(m):
            dp[i][0] = 1
            
        for i in range(1,m):
            for j in range(1,n):
                if j<coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]
                    
        return dp[m-1][n-1]