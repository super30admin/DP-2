"""
Time Complexity : O(mn) where m is the length of coins array & n is amount
Space Complexity : O(mn) where m is the length of coins array & n is amount
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        if len(coins) == 0:
            return 0
        # Initialize my matrix to zero case for 0
        dp = [[0] * (amount + 1) for i in range(len(coins) + 1)]
        
        # Initialize the 0 amount case
        for i in range(len(coins)+1):
            dp[i][0] = 1
        # Filling up my template matrix to number of ways based on 
        # choose and not choose case
        for i in range(1, len(coins) + 1):
            for j in range(1, len(dp[0])):
                if j < coins[i - 1]:
                    dp[i][j] = dp[i - 1][j]
                else:
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]]
        return dp[len(dp) - 1][len(dp[0]) - 1]