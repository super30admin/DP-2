#  Time Complexity : O(m)
#  Space Complexity : O(1)
#  Did this code successfully run on Leetcode : Yes
#  Three line explanation of solution in plain english : It starts from the last row of the costs matrix, where colorR, colorB, and colorG represent the minimum cost to paint from house i to the end if house i is painted Red, Blue, or Green. Iterating backward, for each house, it updates the cost by adding the current painting cost plus the minimum of the other two colors from the next house. Finally, it returns the minimum among colorR, colorB, and colorG, representing the cheapest way to paint all houses.

class Solution:
    def minCost(self, costs):
        m = len(costs)
        n = len(costs[0])
        
        colorR = costs[m - 1][0]
        colorB = costs[m - 1][1]
        colorG = costs[m - 1][2]
        
        for i in range(m - 2, -1, -1):
            tempR = colorR
            tempB = colorB
            
            colorR = costs[i][0] + min(colorB, colorG)
            colorB = costs[i][1] + min(tempR, colorG)
            colorG = costs[i][2] + min(tempR, tempB)
            
        return min(colorR, colorB, colorG)


#  Time Complexity : O(m)
#  Space Complexity : O(m)
#  Did this code successfully run on Leetcode : Yes
#  Three line explanation of solution in plain english : Here, dp[i][c] represents the minimum cost to paint houses up to index i when house i is painted with color c (0 = red, 1 = blue, 2 = green). The base case is the first house (dp[0][*] = costs[0][*]). For each subsequent house i, the recurrence ensures no two adjacent houses have the same color by choosing the minimum cost from the previous row but excluding the same color. At the end, the minimum of the last row (dp[m-1]) gives the final answer.

# class Solution:
#     def minCost(self, costs):
#         m = len(costs)
#         n = len(costs[0])
        
#         dp = [[0] * n for _ in range(m)]
        
#         dp[0][0] = costs[0][0]
#         dp[0][1] = costs[0][1]
#         dp[0][2] = costs[0][2]
        
#         for i in range(1, m):
#             dp[i][0] = costs[i][0] + min(dp[i-1][1], dp[i-1][2])
#             dp[i][1] = costs[i][1] + min(dp[i-1][0], dp[i-1][2])
#             dp[i][2] = costs[i][2] + min(dp[i-1][0], dp[i-1][1])
        
#         return min(dp[m-1][0], dp[m-1][1], dp[m-1][2])


