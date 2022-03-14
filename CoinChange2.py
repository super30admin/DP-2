# Time Complexity : O(amount*number of coins)
# Space Complexity : O(amount * number of coins)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

from typing import List
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
#                                     Amount(Columns)       
#                             0   1   2   3   4   5
#                    []       
#                    [1]
#         Coins(Rows)[1,2]
#                    [1,2,5]
        
#         #CHOOSE- Check in the same row, amount - coin
#     AND #DON'T CHOOSE - Go up in the same col, i.e check the previous value i.e nothing changed
        
        dp=[0]*(amount+1)
        
        dp[0]=1 # There's 1 way to make up 0, which is to do nothing
        
        for coin in range(len(coins)):  #ROWS
            for amt in range(1, amount+1): #COLS
                if amt-coins[coin]>=0:
                    dp[amt]=dp[amt] + dp[amt-coins[coin]]
# dp[amt]= dp[amt] which is the ways in which you can make up the coins if you dont 
# choose the current coin, i.e you just go up in the same column,i.e you dont add the coin
# PLUS the dp[amt-coin] which is the ways with which you can make up if you choose the coin
# i.e you go back in the row by subtracting amount minus current coin and check how much was # # # needed to make that amount
                    
        return dp[-1]
                