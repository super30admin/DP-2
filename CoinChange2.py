'''
Time Complexity - O(mn) where is number of coins and n is the amount
Space Complexity = O(mn) used to store the matrix of size m*n
'''


class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        m = len(coins)
        n = amount
        dp = [[0 for x in range(n+1)] for y in range(m+1)]
        dp[0][0] = 1

        for i in range(1, len(dp)):
            for j in range(0, len(dp[0])):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = (dp[i-1][j]+dp[i][j-coins[i-1]])
        return dp[m][n]
