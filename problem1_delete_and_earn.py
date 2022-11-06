#https://leetcode.com/problems/coin-change-ii/solutions/
# Time Complexity : O(m) where m = rows and n = cols in costs matrix
# Space Complexity : O(m * n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution(object):
    def minCost(self, costs):
        """
        :type costs: List[List[int]]
        :rtype: int
        """
        rows = len(costs)
        cols = len(costs[0])
        houses = [[0 for x in range(cols)] for y in range(rows)]
        houses[0] = costs[0]
        for i in range(1, rows):
            houses[i][0] = costs[i][0] + min(houses[i-1][1],houses[i-1][2])
            houses[i][1] = costs[i][1] + min(houses[i-1][0],houses[i-1][2])
            houses[i][2] = costs[i][2] + min(houses[i-1][1],houses[i-1][0])
        return min(houses[rows-1])