# Problem2 (https://leetcode.com/problems/coin-change-2/)

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        m = len(coins)
        n = amount
        dp = [[0] * (n+1)] * (m+1)
        dp[0][0] = 1
        for i in range(1, m+1):
            for j in range(n+1):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]
        return dp[m][n]

#time and space complexity O(m*n)