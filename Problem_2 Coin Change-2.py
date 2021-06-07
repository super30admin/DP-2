# // Time Complexity : O(m*n) Where m and n are number of rows and columns
# // Space Complexity : O(m*n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this :
#
#
# // Your code here along with comments explaining your approach



class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        rows = len(coins) + 1
        columns = amount + 1

        dp = [[0 for i in range(columns)] for j in range(rows)]

        #Fill First Column with 1
        for i in range(1, rows):
            dp[i][0] = 1

        # Matrix Filling
        for i in range(1, rows):
            for j in range(1, columns):
                if j < coins[i - 1]:
                    dp[i][j] = dp[i - 1][j]
                else:
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]]
        return dp[rows - 1][columns - 1]




