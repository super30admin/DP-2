# Problem 2 : Coin Change II
# Time Complexity :
'''
2-d array - O(m*n) where m is the length of the coins list and n is the amount
1-d array - O(m*n) where m is the length of the coins list and n is the amount
'''
# Space Complexity :
'''
2-d array - O(m*n) where m is the length of the coins list and n is the amount
1-d array - O(n) where n is the amount
'''
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
'''
None
'''

# Your code here along with comments explaining your approach
# 2-d array
from typing import List

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        # if the coins list is None or the length of the list is 0 then return 0
        if coins is None or len(coins) == 0:
            return 0
        # get the length of the coins list and the amount
        m = len(coins)
        n = amount
        # define the dp array with size (m*n) and fill with 0
        dp = [[0] * (n+1) for _ in range(m+1)]
        # set the value at 0th row and 0th column with 1
        dp[0][0] = 1

        # loop from 1 to (m+1)
        for i in range(1, m+1):
            # loop from 0 to (n+1)
            for j in range(n+1):
                # check if the coin at (i-1)th position is greater than j amount
                if coins[i-1] > j:
                    # if it is then set the value of dp[i][j] is dp[i-1][j]
                    dp[i][j] = dp[i-1][j]
                else:
                    # else set the value as sum of dp[i-1][j](previous row and same column) and dp[i][j-coins[i-1]] (same row and coins[i-1] back in the row)
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]]
        # return the value of dp at m and n position
        return dp[m][n]
    
# 1-d array
from typing import List
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        # if the coins list is None or the length of the list is 0 then return 0
        if coins is None or len(coins) == 0:
            return 0
        # defing dp array with size (amount+1) and fill with 0
        dp = [0] * (amount + 1)
        # set the value at 0th position with 1
        dp[0] = 1
        # loop from 0 to length of coins
        for i in range(len(coins)):
            # loop from coins[i] value to amount+1
            for j in range(coins[i], amount+1):
                # calculate dp[j] as sum of dp[j] and dp[j-coins[i]] 
                dp[j] = dp[j] + dp[j - coins[i]]
        # return value at amount th position
        return dp[amount]
