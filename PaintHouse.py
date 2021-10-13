"""
Time Complexity: O(n)
Space Complexity: O(n^2)
"""

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if len(costs) == 0:
            return 0

        for i in range(len(costs) - 2, -1, -1):  # starting with second last row as we will be using the elements from
            # the bottom row
            costs[i][0] = costs[i][0] + min(costs[i + 1][1], costs[i + 1][2])
            costs[i][1] = costs[i][1] + min(costs[i + 1][0], costs[i + 1][2])
            costs[i][2] = costs[i][2] + min(costs[i + 1][0], costs[i + 1][1])

        return min(costs[0][0], costs[0][1], costs[0][2])

