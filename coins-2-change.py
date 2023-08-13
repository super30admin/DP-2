class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        if len(coins) == 0:
            return 0

        n = amount+1
        m = len(coins)
        

        dp = [[0 for i in range(n)] for i in range(m+1)]
        dp[0][0] = 1
        

        for i in range(1,m+1):
            for j in range(0,n):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    
                    dp[i][j] = dp[i-1][j]+dp[i][j-coins[i-1]]
        return dp[m][n-1]
        