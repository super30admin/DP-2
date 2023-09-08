# Time Complexity : O(m*n)
# Space Complexity : O(m*n)

class Solution(object):
    def change(self, amount, coins):
        """
        :type amount: int
        :type coins: List[int]
        :rtype: int
        """
        row = len(coins) + 1
        col = amount +1

        dp = [[0 for x in range(col)] for x in range(row)]
        dp[0][0] = 1

        for i in range (1, row):
            dp[i][0] = 1

        for i in range (1, col):
            dp[0][i] = 0

        for i in range(1,row):
            for j in range(1,col):
                if coins[i-1]>j:
                    dp[i][j]=dp[i-1][j]
                else:
                    dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]]
        return dp[row-1][col-1]
