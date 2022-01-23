"""
You are given an integer array coins representing coins of different 
denominations and an integer amount representing a total amount of money.

Return the number of combinations that make up that amount. 
If that amount of money cannot be made up by any combination of the coins, 
return 0.

You may assume that you have an infinite number of each kind of coin.

The answer is guaranteed to fit into a signed 32-bit integer.

"""

# Time Complexity : O(m*n) m is number of coins, n is numbers of amount 
# Space Complexity : O(m*n)
# Did this code successfully run on leetcode : Yes
# Any problem you faced while coding this : No

from typing import List

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        if len(coins) == 0:
            return 0
    
        dp = [[0]*(amount+1)]*((len(coins)+1))
        
        for i in range(0, len(dp)):
            dp[i][0] = 1
            
        for i in range(1, len(dp)):
            for j in range(1, len(dp[0])):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]

        
        return dp[(len(dp)) - 1][len(dp[0]) - 1]