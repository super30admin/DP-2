class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        if(len(coins) == 0):
            return 0
        m = len(coins)
        n = amount
        dp = [0] * (m+1)
        for i in range(m+1):
            dp[i] = [0] * (n+1)
        
        for j in range(m+1):
            dp[j][0] = 1
        
        for i in range(1,m+1):
            for j in range(1,n+1):
                if(j < coins[i-1]):
                    dp[i][j] = dp[i-1][j]
                
                else:
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]]
                
        return dp[m][n]
                    