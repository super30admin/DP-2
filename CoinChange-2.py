# // Time Complexity : m - number of denominations n is the amount tabulation o(m*n) memoization (o(m*n)) recursion o(2^m+n) 
# // Space Complexity : 1d optimize o(n) recursion and tabulation same as time complexity
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this :
#  faced issues while thinking about return case in memoization and convertion to 1d dp array


# // Your code here along with comments explaining your approach
# idea is to either include a coin or not include a coin and see number of ways we can have a valid amount of 0 
# implement the recursive solution and then handle repeated subproblems using matrix
# base cases will be when amount is 0 return 1 and return 0 when amount< 0 or index out of bound

from typing import List
# Approach 1: recursion
# class Solution:
#     def change(self, amount: int, coins: List[int]) -> int:
        
#         def helper(coins, amount, idx):
#             # base case
#             if amount == 0: return 1
#             if amount < 0 or idx>=len(coins): return 0

#             # logic
#             res = 0
#             # do not choose coin
#             notchoose = helper(coins, amount, idx+1)
#             # choose the coin
#             choose = helper(coins, amount - coins[idx], idx)   
#             return choose+notchoose

#         return helper(coins, amount, 0)

# Approach 2: class Solution: top down approach
# class Solution:
#     def change(self, amount: int, coins: List[int]) -> int:
#         dp = [[0 for j in range(amount +1)] for _ in range(len(coins)+1)]
#         dp[0][0] = 1
#         for i in range(len(coins) +1):
#             dp[i][0] = 1
#         for j in range(1, amount+1):
#             dp[0][j] = 0
#         for i in range(1,len(coins)+1):
#             for j in range(1, amount+1):
#                 if j < coins[i-1]:
#                     dp[i][j] = dp[i-1][j]
#                 else:
#                     dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]
#         return dp[len(coins)][amount]

# Approach 3: space optimized dp
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        dp = [0 for j in range(amount +1)]
        dp[0] = 1
        for i in range(1, len(coins)+1):
            for j in range(1, amount+1):
                if j < coins[i-1]:
                    dp[j] = dp[j]
                else:
                    dp[j] = dp[j] + dp[j-coins[i-1]]
        return dp[amount]

# Approach 4: memoizations
# class Solution:
#     def change(self, amount: int, coins: List[int]) -> int:
#         memo = [[-2 for j in range(amount+1)] for i in range(len(coins)+1)] 
#         def helper(coins, amount, idx):
#             # base case
#             if amount == 0: return 1
#             if amount < 0 or idx>=len(coins): return 0
#             if memo[idx][amount] != -2 : return memo[idx][amount]

#             # logic
#             res = 0
#             # do not choose coin
#             notchoose = helper(coins, amount, idx+1)
#             # choose the coin
#             choose = helper(coins, amount - coins[idx], idx)   
#             memo[idx][amount] = choose+notchoose
#             return choose+notchoose

#         return helper(coins, amount, 0)
        

        

        

        
        
