# DP - 2

## Problem2 (https://leetcode.com/problems/coin-change-2/)

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        if not coins:
            return 0
        
#         Brute Force Method
#         def helper(index, amount, coins, numWays):
#             #basecase
#             if(amount == 0):
#                 numWays+=1
#                 return numWays
#             if not coins or amount<0 or index >= len(coins):
#                 return 0
#             #case1
#             case1 = helper(index, amount-coins[index], coins, numWays)
#             #case0
#             case0 = helper(index+1,amount,coins,numWays)
            

#             return case0 + case1
            
#         return helper(0,amount,coins,0)
                            
    
        dp = [ [0 for i in range(amount+1)] for j in range(len(coins))]
        
        for x in range(len(coins)):
            for y in range(amount+1):
                if y==0:
                    dp[x][y] = 1
                else:
                    dp[x][y] = dp[x-1][y] if coins[x]>y else dp[x][y-coins[x]] + dp[x-1][y]
        return dp[len(coins)-1][amount]
