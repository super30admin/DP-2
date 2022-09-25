# // Time Complexity : O(m*n)     m = len(coins) , n = amount
# // Space Complexity : O(m*n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this :
from typing import List
#dp solution
def change(amount: int, coins: List[int]) -> int:
    m = len(coins)
    n = amount
    
    dp = [[0] * (n+1) for _ in range(m+1)]
    # print(dp)
    for _ in range(len(coins) + 1):
        dp[_][0] = 1
    # print(dp)
    for i in range(1, len(coins) + 1):
        for j in range(1, amount + 1):
            if j < coins[i-1]:
                dp[i][j] = dp[i-1][j]
            else:
                dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]]
                
    return dp[m][n]
        
        
        
# #recursive solution
#     def change(self, amount: int, coins: List[int]) -> int:
#         return self.helper(coins, amount, 0)
    
#     def helper(self, coins: List[int], amount: int, index: int) -> int:
#         #base case
#         if(amount == 0):
#             return 1
#         if(amount < 0 or index == len(coins)):
#             return 0
        
#         #logic
        
#         #case 0 - do not choose the current coin
#         case0 = self.helper(coins, amount, index+1)
        
#         #case 1 - choose the current coin
#         case1 = self.helper(coins, amount - coins[index], index)
        
#         return case0 + case1


amount = 5
coins = [1,2,5]

print(change(amount, coins))