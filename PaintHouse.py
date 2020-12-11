# Time complexity : O(n) ; n = number of houses
# Space complexity : O(1) 
# Approach : We start from the second house, and store its own cost + minimum of other two color's cost of previous house,
# that way we store min. cost for every house of all combinations, in the last row, minimum of all costs is our answer.

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if not costs or len(costs) == 0:
            return 0
        n = len(costs)
        for i in range(1, len(costs)):
            costs[i][0] = costs[i][0] + min(costs[i - 1][1], costs[i - 1][2])
            costs[i][1] = costs[i][1] + min(costs[i - 1][0], costs[i - 1][2])
            costs[i][2] = costs[i][2] + min(costs[i - 1][0], costs[i - 1][1])
        
        return min(costs[n -1][0], min(costs[n - 1][1], costs[n - 1][2]))

# Recursive solution : Time limit exceeded
# class Solution:
#     def minCost(self, costs: List[List[int]]) -> int:
#         if not costs or len(costs) == 0:
#             return 0
        
#         case1 = self.helper(costs, 0, 0, 0) #red
#         case2 = self.helper(costs, 0, 1, 0) #blue
#         case3 = self.helper(costs, 0, 2, 0) #green
        
#         return min(case1, min(case2, case3))
    
#     def helper(self, costs, row, color, minCost):
#         #base
#         if row == len(costs):
#             return minCost
        
#         #logic
#         case1 = float('inf')
#         case2 = float('inf')
#         case3 = float('inf')
        
#         if color == 0:
#             case2 = self.helper(costs, row + 1, 1, minCost + costs[row][1])
#             case3 = self.helper(costs, row + 1, 2, minCost + costs[row][2])
            
#         if color == 1:
#             case1 = self.helper(costs, row + 1, 0, minCost + costs[row][0])
#             case3 = self.helper(costs, row + 1, 2, minCost + costs[row][2])
            
#         if color == 2:
#             case1 = self.helper(costs, row + 1, 0, minCost + costs[row][0])
#             case2 = self.helper(costs, row + 1, 1, minCost + costs[row][1])
            
            
#         return min(case1, min(case2, case3))