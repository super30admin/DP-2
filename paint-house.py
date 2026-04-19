
# 1d array O(n), O(1)
class Solution:
    def minCost(self, costs):
        m = len(costs)
        n = len(costs[0])

        colorR = costs[m-1][0]
        colorB = costs[m-1][1]
        colorG = costs[m-1][2]

        for i in range(m-2, -1, -1):
            tempR = colorR
            tempB = colorB

            colorR = costs[i][0] + min(colorB, colorG)
            colorB = costs[i][1] + min(tempR, colorG)
            colorG = costs[i][2] + min(tempR, tempB)

        return min(colorR, colorB, colorG)

# 2d array 
# O(n) time, O(n) space 
class Solution:
    def minCost(self, costs):
        m = len(costs)
        n = len(costs[0])

        dp = [[0] * n for _ in range(m)]

        dp[0][0] = costs[0][0]
        dp[0][1] = costs[0][1]
        dp[0][2] = costs[0][2]

        for i in range(1, m):
            dp[i][0] = costs[i][0] + min(dp[i-1][1], dp[i-1][2])
            dp[i][1] = costs[i][1] + min(dp[i-1][0], dp[i-1][2])
            dp[i][2] = costs[i][2] + min(dp[i-1][0], dp[i-1][1])

        return min(dp[m-1][0], dp[m-1][1], dp[m-1][2])


# recursive with memoization O(n) time, O(n) space
# class Solution:
#     def minCost(self, costs):  # 0-R, 1-B, 2-G
#         n = len(costs)
#         self.memo = [[0]*3 for _ in range(n)]
#         colorR = self.helper(costs, 0, 0)
#         colorB = self.helper(costs, 0, 1)
#         colorG = self.helper(costs, 0, 2)

#         return min(colorR, min(colorB, colorG))

#     def helper(self, costs, i, color):
#         if i == len(costs):
#             return 0

#         if self.memo[i][color] != 0:
#             return self.memo[i][color]

#         result = 0
#         if color == 0:
#             result = min(self.helper(costs, i+1, 1) + costs[i][0],
#                          self.helper(costs, i+1, 2) + costs[i][0])
#         elif color == 1:
#             result = min(self.helper(costs, i+1, 0) + costs[i][1],
#                          self.helper(costs, i+1, 2) + costs[i][1])
#         elif color == 2:
#             result = min(self.helper(costs, i+1, 0) + costs[i][2],
#                          self.helper(costs, i+1, 1) + costs[i][2])

#         self.memo[i][color] = result
#         return result