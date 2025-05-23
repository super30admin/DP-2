# // Time Complexity : m - houses n - colors recursion - o(n2^m) dp (o(n*m))
# // Space Complexity : o(2^m) dp - o(n*m)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : 
#  some issues in the for each range while filling the array but visualizing the solution on paper solved it


# // Your code here along with comments explaining your approach
# try greedy but since we dont know costs beforehand we can try exhaustive search so basically choosing one paint for a house and deciding what should be painted in others
# handle base case where if we cross the end house we return 0 , solution will be to get min of all the cost of each subproblem

from typing import List
# Approach 1 : 
# class Solution: reccusive
#     def minCost(self, costs: List[List[int]]) -> int:

#         def helper(costs, idx, color):
#             if idx >= len(costs) : return 0
#             if idx == len(costs)-1: return costs[idx][color]
#             res = 0
#             if color == 0:
#                 return costs[idx][color]+ min(helper(costs, idx+1, 1),helper(costs, idx+1, 2))
#             if color == 1:
#                 return costs[idx][color]+min(helper(costs, idx+1, 0),helper(costs, idx+1, 2))
#             if color == 2:
#                 return costs[idx][color]+min(helper(costs, idx+1, 1),helper(costs, idx+1, 0))
            
#             return 34523423
            
#         varR = helper(costs, 0, 0)
#         varB = helper(costs, 0, 1)
#         varG = helper(costs, 0, 2)
#         return min(varR, varB, varG)

# Approach 2: dp bottom up
# class Solution:
#     def minCost(self, costs: List[List[int]]) -> int:
#         n = len(costs)
#         dp = [[0 for j in range(3)] for i in range(n)]
#         for j in range(3):
#             dp[n-1][j] = costs[n-1][j]
#         for i in range(n-2,-1,-1):
#             dp[i][0] = costs[i][0] + min(dp[i+1][1], dp[i+1][2])
#             dp[i][1] = costs[i][1] + min(dp[i+1][0], dp[i+1][2])
#             dp[i][2] = costs[i][2] + min(dp[i+1][0], dp[i+1][1])
#         return min(dp[0][0], dp[0][1] , dp[0][2])

# Approach 3: space optimized o(1)
class Solution: 
    def minCost(self, costs: List[List[int]]) -> int:
        n = len(costs)
        varR = costs[n-1][0]
        varB = costs[n-1][1]
        varG = costs[n-1][2]
        for i in range(n-2,-1,-1):
            tempR = varR
            varR = costs[i][0] + min(varB, varG)
            tempB = varB
            varB = costs[i][1] + min(tempR, varG)
            varG = costs[i][2] + min(tempR, tempB)
        return min(varR, varB , varG)

# Approach 4: 
# class Solution: memoization
#     def minCost(self, costs: List[List[int]]) -> int:
#         memo = [[-2 for j in range(3)] for i in range(len(costs))]
#         def helper(costs, idx, color):
#             if idx >= len(costs) : return 0
#             if idx == len(costs)-1: return costs[idx][color]
#             if memo[idx][color] != -2 : return memo[idx][color]
#             res = 0
#             if color == 0:
#                 memo[idx][color] = costs[idx][color]+ min(helper(costs, idx+1, 1),helper(costs, idx+1, 2))
#                 return memo[idx][color]
#             if color == 1:
#                 memo[idx][color] = costs[idx][color]+min(helper(costs, idx+1, 0),helper(costs, idx+1, 2))
#                 return memo[idx][color]
#             if color == 2:
#                 memo[idx][color] = costs[idx][color]+min(helper(costs, idx+1, 1),helper(costs, idx+1, 0))
#                 return memo[idx][color]
            
#             return 34523423
            
#         varR = helper(costs, 0, 0)
#         varB = helper(costs, 0, 1)
#         varG = helper(costs, 0, 2)
#         return min(varR, varB, varG)
        
        
