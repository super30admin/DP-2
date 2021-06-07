from typing import List

# Recursive Solution
# class Solution:
#     def minCost(self, costs: List[List[int]]) -> int:
#         if costs == None or len(costs) == 0:
#             return 0
#         case1 = self.helper(costs, 0, 0, 0)
#         case2 = self.helper(costs, 0, 1, 0)
#         case3 = self.helper(costs, 0, 2, 0)
#         return min(case1, case2, case3)
    
#     def helper(self, costs: List[List[int]], row: int, color: int, totalCost: int) -> int:
        
#         if row == len(costs):
#             return totalCost
        
#         if color == 0:
#             return min(self.helper(costs, row + 1, 1, totalCost + costs[row][0]),
#                        self.helper(costs, row + 1, 2, totalCost + costs[row][0]))
        
#         if color == 1:
#             return min(self.helper(costs, row + 1, 0, totalCost + costs[row][1]),
#                        self.helper(costs, row + 1, 2, totalCost + costs[row][1]))
        
#         if color == 2:
#             return min(self.helper(costs, row + 1, 0, totalCost + costs[row][2]),
#                        self.helper(costs, row + 1, 1, totalCost + costs[row][2]))


class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if costs == None or len(costs) == 0:
            return 0
        
        for i in range(len(costs) - 2, -1, -1):
            costs[i][0] = costs[i][0] + min(costs[i+1][1], costs[i+1][2])
            costs[i][1] = costs[i][1] + min(costs[i+1][0], costs[i+1][2])
            costs[i][2] = costs[i][2] + min(costs[i+1][0], costs[i+1][1])
        
        return min(costs[0][0], costs[0][1], costs[0][2])


# Optimized Solution - without mutating array
# class Solution:
#     def minCost(self, costs: List[List[int]]) -> int:
#         if costs == None or len(costs) == 0:
#             return 0
        
#         prevB = costs[len(costs) - 1][0]
#         prevR = costs[len(costs) - 1][1]
#         prevG = costs[len(costs) - 1][2]
        
#         for i in range(len(costs) - 2, -1, -1):
#             tempB = prevB
#             tempR = prevR
#             prevB = costs[i][0] + min(prevR, prevG)
#             prevR = costs[i][1] + min(tempB, prevG)
#             prevG = costs[i][2] + min(tempB, tempR)
        
#         return min(prevB, prevR, prevG)


obj = Solution()
print(obj.minCost([[17,2,17],[16,16,5],[14,3,19]]))
print(obj.minCost([[7,6,2]]))


# Time Complexity : O(n)
# Space Complexity : O(1)