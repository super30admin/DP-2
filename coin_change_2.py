# tc O(n*amount)
# sc O(n*amount)
from typing import List


class Solution:    
    def change(self, amount: int, coins: List[int]) -> int:
            if len(coins) ==0 :
                return 0
            dp = [[0]*(amount+ 1) ]*(len(coins) + 1)
            dp[0][0] = 1
            # first column 1 always
            for i in range(0, len(dp)):
                dp[i][0] = 1
            
            for i in range(1, len(dp)):
                for j in range(1, amount +1):
                # till amount is less than demomination 
                    if j< coins[i-1]:
                        dp[i][j] = dp[i-1][j]
                    else:
                        dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]] # + because we are considering all possibilities
            
            return dp[len(coins)][amount]



# def helper(amount, coins, index):
#         # base 
#         if amount == 0 :
#             return 1 
#         if amount < 0 and index >= len(coins):
#             return 0
#         # logic
#         # choose coin
#         case1 = helper( amount - coins[index], coins, index)
#         # not choose coin
#         case2 = helper(amount, coins, index + 1)
        
# class Solution:
    
#     def change(self, amount: int, coins: List[int]) -> int:
#         if len(coins) ==0 :
#             return 0
#         return helper(amount, coins, 0)