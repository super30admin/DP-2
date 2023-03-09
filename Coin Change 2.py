# Time Complexity :  O(mn) m = number of coins, n = amount
# Space Complexity : O(mn)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        m = len(coins)
        n = amount
        dp = [[0 for j in range(n+1)] for i in range(m+1)]

        dp[0][0] = 1

        for i in range(1,m+1):
            for j in range(n+1):
                if coins[i-1] > j:
                    dp[i][j] = dp[i-1][j]
                else:   
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]
        return dp[m][n]
