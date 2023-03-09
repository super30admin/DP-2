# Time Complexity - O(mn)
# Space Complexity - O(mn)


class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        m = len(coins)
        n = amount
        dp = [[0 for j in range(n+1)] for i in range(m+1)]
        for i in range(m+1):
            dp[i][0] = 1
        for i in range(1,m+1):
            for j in range(1,n+1):
                if coins[i-1] > j : 
                    dp[i][j] = dp[i-1][j]
                else :
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]
        return dp[m][n]
