# Time Complexity :
# O(MN)

# Space Complexity :
# O(1)

# Did this code successfully run on Leetcode :
#Yes

#We traverse this matrix bottom up - and store the best cost to pain the current house - That best cost is it's own cost + minimum of its potential next houses - that are, using a different colour for the other houses
#We do this at all elements and return the minimum from the first row - since we start from the first house.

class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        n = len(matrix)
        m = len(matrix[0])
        dp = [[0]*m for i in range(n)]

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:

        n = len(costs)
        m = len(costs[0])

        for i in reversed(range(0,n-1)):
            for j in range(0,m):
                costs[i][j] = min(costs[i+1][:j] + costs[i+1][j+1:]) + costs[i][j]

        return min(costs[0])
