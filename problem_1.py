# Time Complexity : O(m)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#
# Your code here along with comments explaining your approach


# not-mutating the matrix
class Solution:
    def minCost(self, costs):
        n = len(costs)
        red, green, blue = costs[n-1][0], costs[n-1][1], costs[n-1][2]
        for i in range(n-2, -1, -1):
            tempr, tempg, tempb = red, green, blue
            red = costs[i][0] + min(tempg, tempb)
            green = costs[i][1] + min(tempr, tempb)
            blue = costs[i][2] + min(tempr, tempg)
        return min(red, green, blue)


check = Solution()
print(check.minCost([[17, 2, 17], [16, 16, 5], [14, 3, 19]]))


# not mutating the matrix - TC - O(m*n), SC - O(m*n)
# class Solution:
#     def minCost(self, costs):
#         n = len(costs)
#         dp = []
#         for i in range(n):
#             dp.append([0]*3)
#         dp[n-1][0], dp[n-1][1], dp[n-1][2] = costs[n-1][0], costs[n-1][1], costs[n-1][2]
#         for i in range(n-2, -1, -1):
#             dp[i][0] += costs[i][0] + min(dp[i + 1][1], dp[i + 1][2])
#             dp[i][1] += costs[i][1] + min(dp[i + 1][0], dp[i + 1][2])
#             dp[i][2] += costs[i][2] + min(dp[i + 1][0], dp[i + 1][1])
#         return min(dp[0][0], dp[0][1], dp[0][2])

#
# check = Solution()
# print(check.minCost([[17, 2, 17], [16, 16, 5], [14, 3, 19]]))


# # mutating the matrix - TC - O(m*n), SC - O(m*n)
# class Solution:
#     def minCost(self, costs):
#         n = len(costs)
#         for i in range(n-2, -1, -1):
#             costs[i][0] += min(costs[i+1][1], costs[i+1][2])
#             costs[i][1] += min(costs[i+1][0], costs[i+1][2])
#             costs[i][2] += min(costs[i+1][0], costs[i+1][1])
#         return min(costs[0][0], costs[0][1], costs[0][2])
#
#
# check = Solution()
# print(check.minCost([[17, 2, 17], [16, 16, 5], [14, 3, 19]]))


# class Solution:
#     def minCost(self, costs):
#         n = len(costs)
#         for i in range(n-2, -1, -1):
#             for j in range(3):
#                 if j == 0:
#                     costs[i][0] += min(costs[i+1][1], costs[i+1][2])
#                 elif j == 1:
#                     costs[i][1] += min(costs[i+1][0], costs[i+1][2])
#                 elif j == 2:
#                     costs[i][2] += min(costs[i+1][0], costs[i+1][1])
#         return min(costs[0][0], costs[0][1], costs[0][2])
#
#
# check = Solution()
# print(check.minCost([[17, 2, 17], [16, 16, 5], [14, 3, 19]]))


# Recursion - Time Limit Exceeded.
# class Solution:
#     def helper(self, costs, house, index, min_cost):
#         # base-case
#         if house == len(costs):
#             return min_cost
#         # logic
#         if index == 0:
#             case1 = self.helper(costs, house+1, 1, min_cost + costs[house][index])
#             case2 = self.helper(costs, house+1, 2, min_cost + costs[house][index])
#             return min(case1, case2)
#         elif index == 1:
#             case1 = self.helper(costs, house+1, 0, min_cost + costs[house][index])
#             case2 = self.helper(costs, house+1, 2, min_cost + costs[house][index])
#             return min(case1, case2)
#         else:
#             case1 = self.helper(costs, house+1, 0, min_cost + costs[house][index])
#             case2 = self.helper(costs, house+1, 1, min_cost + costs[house][index])
#             return min(case1, case2)
#
#     def minCost(self, costs):
#         red = self.helper(costs, 0, 0, 0)
#         green = self.helper(costs, 0, 1, 0)
#         blue = self.helper(costs, 0, 2, 0)
#         return min(red, green, blue)
#
#
# check = Solution()
# print(check.minCost([[17, 2, 17], [16, 16, 5], [14, 3, 19]]))
