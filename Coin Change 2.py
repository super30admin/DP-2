# time complexity is o(mn), where 'm' is the input coins, 'n' is the amount
# space complexity is o(mn), where 'm' is the input coins, 'n' is the amount
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        if(len(coins) == 0):
            return 0
        n = amount
        m = len(coins)
        dp = [[0 for i in range(n+1)] for i in range(m+1)]
        dp[0][0] = 1
        for i in range(1,n+1):
            dp[0][i] = 0
        for i in range(1,m+1):
            for j in range(n+1):
                if(j < coins[i-1]):
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]]
        return dp[m][n]
        
        