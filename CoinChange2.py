#Time Complexity : O(mn) where m is the length of input array i.e. number of coins and n is amount
#Space Complexity : O(mn) where m is the length of input array i.e. number of coins and n is amount
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No


class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        rows, cols = len(coins)+1, amount+1
        dp = [[0 for _ in range(cols)] for _ in range(rows)]

        dp[0][0] = 1

        for i in range(1, rows):
            dp[i][0] = 1
            for j in range(1, cols):
                if j >= coins[i-1]:
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]
                else:
                    dp[i][j] = dp[i-1][j]

        return dp[rows-1][cols-1]
