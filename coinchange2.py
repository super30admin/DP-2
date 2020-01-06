# time complexity = O(n*m)
#space complexity = O(n*m)
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        dp = [[0 for _ in range(amount+1)] for _ in range(len(coins)+1)]
        m=len(dp)
        n=len(dp[0])
        dp[0][0] = 1
        for i in range(1,m):
            dp[i][0] = 1
            for j in range(n):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]
        return dp[m-1][n-1]