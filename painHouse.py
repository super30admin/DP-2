# # Recursive Paint House

# # Time Complexity: O(3 * 2^n)

# # Space Complexity: O(3 * 2^n) ~ Tree with 2^n nodes for the 3 choices of colors

# # In this approach, we compute the minimum of the tree nodes below the first choices, and finally choose the minimum between the 3 paths

# class Solution:
#     def minCost(self, costs: List[List[int]]) -> int:
#         if costs is None or len(costs) == 0:
#             return 0
#         caseR = self.helper(costs, 0, 0, 0)
#         caseB = self.helper(costs, 0, 1, 0)
#         caseG = self.helper(costs, 0, 2, 0)
        
#         return min(caseR, min(caseB, caseG))
    
#     def helper(self, costs: List[List[int]], r: int, color: int, minCost: int) -> int:
        
#         # Base Case
#         if r == len(costs):
#             return minCost
#         # Choosing a Color Case
        
#         if (color == 0):
#             return min(self.helper(costs, r+1, 1, minCost + costs[r][0]),
#                       self.helper(costs, r+1, 2, minCost + costs[r][0]))
#         if (color == 1):
#             return min(self.helper(costs, r+1, 0, minCost + costs[r][1]),
#                       self.helper(costs, r+1, 2, minCost + costs[r][1]))
#         if (color == 2):
#             return min(self.helper(costs, r+1, 0, minCost + costs[r][2]),
#                       self.helper(costs, r+1, 1, minCost + costs[r][2]))
        
#         return 99999

# Dp Solution
# Time complexity: O(n) ~ n is the number of houses

# Space Complexity: o(N)

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if costs is None or len(costs) == 0:
            return 0
        n = len(costs)
        dp = [[0 for i in range (3)] for i in range (n)]
        dp[n-1][0] = costs[n-1][0]
        dp[n-1][1] = costs[n-1][1]
        dp[n-1][2] = costs[n-1][2]
        for i in range(n-2, -1, -1):
            dp[i][0] = costs[i][0] + min(dp[i+1][1], dp[i+1][2])
            dp[i][1] = costs[i][1] + min(dp[i+1][0], dp[i+1][2])
            dp[i][2] = costs[i][2] + min(dp[i+1][0], dp[i+1][1])
            
        print(dp)
        return min(dp[0][0], min(dp[0][1], dp[0][2]))

# Optimized DP

# TIme: O(n)
# Space: O(1)

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if costs is None or len(costs) == 0:
            return 0
        n = len(costs)
        
        red = costs[n-1][0]
        blue = costs[n-1][1]
        green = costs[n-1][2]
        for i in range(n-2, -1, -1):
            tempR = red
            tempB = blue
            red = costs[i][0] + min(blue, green)
            blue = costs[i][1] + min(tempR, green)
            green = costs[i][2] + min(tempR, tempB)
            
        
        return min(red, min(blue, green))
