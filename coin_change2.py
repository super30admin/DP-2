# Time Complexity : O(n x m) m : target amount
# Space Complexity: O(n)
class Solution(object):
    def change(self, amount, coins):

        # Initializing starting dummy row of matrix as 0
        dp = [[0] * (amount + 1)] * (len(coins) + 1)
        #         Initializing the first column of matrix as 1 when we reach leaf node that could be the valid path
        for i in range(len(coins) + 1):
            dp[i][0] = 1

        # Iterate over a matrix to update values so that last column last row value will be the desired result
        for i in range(1, len(dp)):
            for j in range(1, amount + 1):
                # Update value as previous row until the current column is less than current coin value
                if j < coins[i - 1]:
                    dp[i][j] = dp[i - 1][j]
                #Update matrix value with addition of previous row value and value at
                # current row - current coulmn minus current coin value
                else:
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]]

        # Return last element in the matrix which will be representing
        # the total number of ways to get the target amount
        return dp[len(coins)][amount]

        """
        :type amount: int
        :type coins: List[int]
        :rtype: int
        """
