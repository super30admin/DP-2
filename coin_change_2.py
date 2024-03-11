from typing import List
"""Optimized solution using bottom up DP.
TC: O(m*n)
SC: O(m*n) where n is lenght of coins array and m is the amount"""
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        n, m = len(coins), amount
        dp = [[None] * (m+1) for _ in range(n+1)]

        # Fill in dummy values
        dp[0][0] = 1
        for j in range(1, m+1):
            dp[0][j] = 0

        # Fill in the table for subproblems
        for i in range(1, n+1):
            for j in range(0 , m+1):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]
        return dp[n][m]



"""The above solution can be optimized further for space. Instead of using matrix, we can use an
array to cache the results of subproblems.
TC: O(m*n), SC: O(m)"""
# Optimization for space to O(m) where m is amount.
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        n, m = len(coins), amount
        dp = [0] * (m+1)

        # Fill in dummy values
        dp[0] = 1

        # Fill in the table for subproblems
        for i in range(1, n+1):
            for j in range(0 , m+1):
                if j < coins[i-1]:
                    dp[j] = dp[j]
                else:
                    dp[j] = dp[j] + dp[j-coins[i-1]]
        return dp[m]


# Exhaustive recursion solution with TLE
# 1. Using a global counter without returning
# class Solution:
#     counter = 0
#     def helper(self, coins, idx, amount):
#         # base case
#         if amount < 0 or idx == len(coins): return 6000
#         if amount == 0:
#             self.counter +=1
#             return

#         # Not choose case
#         case1 = self.helper(coins, idx+1, amount)
#         # Choose case
#         case2 = self.helper(coins, idx, amount - coins[idx])
#     def change(self, amount: int, coins: List[int]) -> int:
#         idx = 0
#         result = self.helper(coins, idx, amount)
#         if result == 6000: return 0
#         return self.counter

# 2. using return int
# class Solution:
#     counter = 0
#     def helper(self, coins, idx, amount):
#         # base case
#         if amount < 0 or idx == len(coins): return 0
#         if amount == 0:
#             return 1

#         # Not choose case
#         case1 = self.helper(coins, idx+1, amount)
#         # Choose case
#         case2 = self.helper(coins, idx, amount - coins[idx])
#         return case1 + case2

#     def change(self, amount: int, coins: List[int]) -> int:
#         idx = 0
#         result = self.helper(coins, idx, amount)
#         if result == 6000: return 0
#         return result