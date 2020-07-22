# Time Complexity : O (n*m) where n is the number of house, m is number of paints
# Space Complexity : O (n*m)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No


class Solution:
    def minCost(self, costs: List[List[int]]) -> int:

        if costs is None or len(costs) == 0 or len(costs[0]) == 0:
            return 0
        # here we are using the costs matrix itself our dp matrix

        # for each home we will choose a color and choose the min of value of the other two colors and add cost of both
        # colors, this way we refer to the previous home colors, optimally we will choose colors based on the min cost
        # also no same color for the neighbour house

        for i in range(1, len(costs)):
            costs[i][0] += min(costs[i - 1][1], costs[i - 1][2])
            costs[i][1] += min(costs[i - 1][0], costs[i - 1][2])
            costs[i][2] += min(costs[i - 1][0], costs[i - 1][1])

        return min(costs[-1][:])
