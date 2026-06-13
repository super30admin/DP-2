# Time Complexity : O(m*n) 
# Space Complexity : O(m*n) 
# Did this code successfully run on Leetcode : yes 
# Any problem you faced while coding this : No

class Solution(object):
    def change(self, amount, coins):
        n, m = len(coins), amount

        # rows = n+1 (coins), cols = m+1 (amount)
        dp = [[0] * (m+1) for _ in range(n+1)]
        dp[0][0] = 1

        for i in range(1, n + 1):
            for j in range(m + 1):
                if j < coins[i - 1]:
                    dp[i][j] = dp[i - 1][j]
                else:
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]]
        
        return dp[n][m]