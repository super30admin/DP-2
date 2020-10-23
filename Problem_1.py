"""
This is the recursive code as of now which I wrote, will be modifying it to DP and submitting again
once I understand how DP can be handled here. Right now, it gives time limit exceeded. Thanks
"""


class Solution:
    """
    @param costs: n x 3 cost matrix
    @return: An integer, the minimum cost to paint all houses
    """

    def minCost(self, costs):
        # write your code here
        if not costs or costs == None:
            return 0
        case1 = self.helper(costs, 1, 0, costs[0][0])
        case2 = self.helper(costs, 1, 1, costs[0][1])
        case3 = self.helper(costs, 1, 2, costs[0][2])
        return min(case1, case2, case3)

    def helper(self, costs, row, color, mincost):
        if row == len(costs):
            return mincost
        if color == 0:
            return min(self.helper(costs, row+1, 1, mincost+costs[row][1]), self.helper(costs, row+1, 2, mincost+costs[row][2]))
        if color == 1:
            return min(self.helper(costs, row+1, 0, mincost+costs[row][0]), self.helper(costs, row+1, 2, mincost+costs[row][2]))
        if color == 2:
            return min(self.helper(costs, row+1, 1, mincost+costs[row][1]), self.helper(costs, row+1, 0, mincost+costs[row][0]))
