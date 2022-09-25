# // Time Complexity : O(n) n =len(costs)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this :

from typing import List
#dp solution
def minCost(costs: List[List[int]]) -> int:
    n =len(costs)
    dp = [[0] * 3 for _ in range(n)]
    
    for _ in range(3):
        dp[-1][_] = costs[-1][_]
        
    for i in range(n-2, -1, -1):
        dp[i][0] = costs[i][0] + min(dp[i+1][1], dp[i+1][2])
        dp[i][1] = costs[i][1] + min(dp[i+1][0], dp[i+1][2])
        dp[i][2] = costs[i][2] + min(dp[i+1][0], dp[i+1][1])
    # print(dp)
    return min(dp[0])
        
        
costs = [[17,2,17],[16,16,5],[14,3,19]]

print(minCost(costs))
        
# #recursive solution
#     def minCost(self, costs: List[List[int]]) -> int:
#         # R - 0, G - 1, B - 2
#         caseR = self.helper(costs, 0, 0, 0)
#         caseG = self.helper(costs, 0, 1, 0)
#         caseB = self.helper(costs, 0, 2, 0)
        
#         return min(caseR, caseG, caseB)
    
#     def helper(self, costs: List[List[int]], index: int, color: int, amount: int) -> int:
#         #base
#         if index == len(costs):
#             return amount
#         #logic
#         if color == 0: #red
#             case1 = self.helper(costs, index+1, 1, amount + costs[index][0])
#             case2 = self.helper(costs, index+1, 2, amount + costs[index][0])
#             return min(case1, case2)
        
#         elif color == 1: #green
#             case0 = self.helper(costs, index+1, 0, amount + costs[index][1])
#             case2 = self.helper(costs, index+1, 2, amount + costs[index][1])
#             return min(case0, case2)
        
#         elif color == 2: #blue
#             case0 = self.helper(costs, index+1, 0, amount + costs[index][2])
#             case1 = self.helper(costs, index+1, 1, amount + costs[index][2])
#             return min(case0, case1)