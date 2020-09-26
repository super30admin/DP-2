"""
Problem: Find the minimum cost to paint all houses with colors red, green, blue of different costs.
Leetcode: https://leetcode.com/problems/paint-house/
Example:
    Input: [[17,2,17],[16,16,5],[14,3,19]]
    Output: 10
Solution: Dynamic programming, We iterate backwards over all the rows in the grid (starting from the second-to-last)
    and calculate a total cost for each cell.
Time Complexity: O(n), where n is the number of houses
Space Complexity: O(1), algorithm is in place, updated the input array
"""


class Solution:
    def min_cost(self, costs):
        if costs is None or len(costs) is 0:
            return 0

        for n in reversed(range(len(costs) - 1)):
            # Total cost of painting nth house red
            costs[n][0] += min(costs[n+1][1],costs[n+1][2])
            # Total cost of painting nth house green
            costs[n][1] += min(costs[n+1][0], costs[n+1][2])
            # total cost of painting nth house blue
            costs[n][2] += min(costs[n+1][0], costs[n+1][1])

        if len(costs) == 0:
            return 0

        # Return the minimum in the first row
        return min(costs[0])


obj = Solution()
print(obj.min_cost([[17,2,17],[16,16,5],[14,3,19]]))