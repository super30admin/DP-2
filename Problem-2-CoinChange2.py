class Solution:
    def change(self, amount, coins):

        if coins == None or len(coins) == 0:
            return 0
        rows = len(coins) + 1
        columns = amount + 1

        dp = [[0 for i in range(columns)] for j in range(rows)]

        for i in range(1, rows):
            dp[i][0] = 1

        for i in range(1, rows):
            for j in range(1, columns):
                if coins[i - 1] > j:
                    dp[i][j] = dp[i - 1][j]
                else:

                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]]

        return dp[rows - 1][columns - 1]

sol=Solution()
coin= [1,2,5]
print (sol.change(5,coin))