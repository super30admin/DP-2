# https://leetcode.com/problems/coin-change-2
# // Time Complexity : o(#ofcoins*amount)
# // Space Complexity : o(ofcoins*amount)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this : None
#
#
# // Your code here along with comments explaining your approach

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        dp = [[0 for i in range(amount + 1)] for j in range(len(coins) + 1)]
        for i in range(0, len(coins) + 1):
            dp[i][0] = 1
        for i in range(1, len(coins) + 1):
            for j in range(1, amount + 1):
                if j < coins[i - 1]:
                    dp[i][j] = dp[i - 1][j]
                else:
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]]

        return dp[len(coins)][amount]

