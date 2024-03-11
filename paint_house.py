from typing import List

# Optimizing below solutioon for space. Instaed of using 2D array, we can just use 1D array or 3 variables
class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        n = len(costs)
        m = len(costs[0])
        dp = [0] * m
        
        r = costs[n-1][0]
        b = costs[n-1][1]
        g = costs[n-1][2]
        
        for i in range(n-2, -1, -1):
            tempr = r
            r = costs[i][0] + min(b, g)
            tempb = b
            b = costs[i][1] + min(tempr, g)
            g = costs[i][2] + min(tempr, tempb)
        
        return min(r,g,b)

# Optimized for repeated subproblems using bottom up DP
# class Solution:
#     def minCost(self, costs: List[List[int]]) -> int:
#         n = len(costs)
#         m = len(costs[0])
#         dp = [[0] * m for _ in range(n)]
#         # Init the last row with same values
#         for j in range(0, m):
#             dp[n-1][j] = costs[n-1][j]
        
#         for i in range(n-2, -1, -1):
#             dp[i][0] = costs[i][0] + min(dp[i+1][1], dp[i+1][2])
#             dp[i][1] = costs[i][1] + min(dp[i+1][0], dp[i+1][2])
#             dp[i][2] = costs[i][2] + min(dp[i+1][0], dp[i+1][1])
        
#         return min(dp[0])

# Exhaustive exploring using recursive solution
# class Solution:
#     def helper(self, costs, house_index, color_index, path_cost_till_now):
#         # base
#         if house_index == len(costs): return path_cost_till_now
#         #logic
#         if color_index == 0:
#             return min(self.helper(costs, house_index+1, 1, path_cost_till_now + costs[house_index][0]),
#             self.helper(costs, house_index+1, 2, path_cost_till_now + costs[house_index][0]))
#         if color_index == 1:
#             return min(self.helper(costs, house_index+1, 0, path_cost_till_now + costs[house_index][1]),
#             self.helper(costs, house_index+1, 2, path_cost_till_now + costs[house_index][1]))
#         if color_index == 2:
#             return min(self.helper(costs, house_index+1, 0, path_cost_till_now + costs[house_index][2]),
#             self.helper(costs, house_index+1, 1, path_cost_till_now + costs[house_index][2]))
#         return 818181
#     def minCost(self, costs: List[List[int]]) -> int:
#         # Here for each color- we are building a subtree. if there are more colours- a for loop is chosen 
#         caseR = self.helper(costs, 0, 0, 0)
#         caseB = self.helper(costs, 0, 1, 0)
#         caseG = self.helper(costs, 0, 2, 0)
#         return min(caseR, min(caseB, caseG))



# Greedy solution- choose less priced color for each house
# class Solution:
#     def minCost(self, costs: List[List[int]]) -> int:
#         min_cost = 0
#         for house_colors_list in costs:
#             min_cost += min(house_colors_list)
#         return min_cost
    
if __name__ == "__main__":
    sol = Solution()
    costs = [[17,2,17],[16,16,5],[14,3,19]]
    print(sol.minCost(costs))