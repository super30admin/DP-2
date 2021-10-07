#Time Complexity = O(n*m)
#Space Complexity = O(n*m)
#compiled and run on leetcode

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        n = len(coins) + 1
        m = amount + 1

        dp = [[0 for i in range(m)] for j in range(n)] #init the 2d matrix

        for j in range(1, m): #init 1st row and 1st col
            dp[0][j] = 0
        for i in range(0, n):
            dp[i][0] = 1

        for i in range(1, n):
            for j in range(1, m):
                if (j < coins[i - 1]): #if target amt is less than denomination
                    dp[i][j] = dp[i - 1][j]
                else:
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]] #dp logic of adding Chose + Dont Chose

        return dp[n - 1][m - 1] #last row gives number of ways