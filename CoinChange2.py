# Time Complexity : O(n x m) where m is target amount
# Space Complexity: O(n)
# ran on leetcode : Yes

class Solution(object):
    def change(self, amount, coins):

        dp = [[0] * (amount + 1)] * (len(coins) + 1)
        # Initialize first row to 1
        for i in range(len(coins) + 1):
            dp[i][0] = 1

        for i in range(1, len(dp)):
            for j in range(1, amount + 1):
                # Update previous row value till denomination is greater value
                if j < coins[i - 1]:
                    dp[i][j] = dp[i - 1][j]
                # Update matrix value with addition of previous row value and value at
                # current row - current column minus current coin value
                else:
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]]

        return dp[len(coins)][amount]
