# Time Complexity: O(N * amount), N is the number of elements in costs list
# Space Complexity: O(amount), we are using only 1D array of size amount
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No


from typing import List

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        rows = len(coins) + 1
        columns = amount + 1

        dp = [None] * columns

        dp[0] = 1

        for col in range(1, columns):
            dp[col] = 0
        
        for row in range(1, rows):
            for col in range(columns):
                if coins[row - 1] > col:
                    dp[col] = dp[col]
                else:
                    dp[col] = dp[col] + dp[col - coins[row - 1]]
        
        return dp[columns - 1]