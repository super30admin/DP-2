# Time Complexity : O(m*n) 
# Space Complexity : O(m*n) if we use 2D array, O(n) if we use 1D array
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# class Solution:
#     def change(self, amount: int, coins: List[int]) -> int:
#         m = len(coins)
#         n = amount
#         dpMatrix = [[0 for _ in range(n+1)] for _ in range(m+1)]
#         dpMatrix[0][0] = 1

#         for i in range(1, m+1):
#             for j in range(n+1):
#                 if  j< coins[i-1]:
#                     dpMatrix[i][j] = dpMatrix[i-1][j]
#                 else:
#                     dpMatrix[i][j] = dpMatrix[i-1][j] + dpMatrix[i][j-coins[i-1]]
#         return dpMatrix[m][n]
    
from typing import List

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        m = len(coins)
        n = amount
        dpMatrix = [0 for _ in range(n+1)]
        dpMatrix[0] = 1

        for i in range(1, m+1):
            for j in range(n+1):
                if  j< coins[i-1]:
                    dpMatrix[j] = dpMatrix[j]
                else:
                    dpMatrix[j] = dpMatrix[j] + dpMatrix[j-coins[i-1]]
        return dpMatrix[n]