# Recursive/Exhaustive
# TLE
class Solution(object):
    def minCost(self, costs):
        """
        :type costs: List[List[int]]
        :rtype: int
        """
        if len(costs) == 0 or costs == None:
            return 0

        # Red = 0, Green = 1, Blue = 2
        caseR = self.helper(costs, 0, 0, 0)
        caseG = self.helper(costs, 0, 0, 1)
        caseB = self.helper(costs, 0, 0, 2)

        return min(caseR, min(caseG, caseB))

    def helper(self, costs, amount, index, color):

        # base
        if index == len(costs):
            return amount

        # logic
        if color == 0:  # red
            return min(self.helper(costs, amount + costs[index][0], index + 1, 1),
                       self.helper(costs, amount + costs[index][0], index + 1, 2))

        if color == 1:  # green
            return min(self.helper(costs, amount + costs[index][1], index + 1, 0),
                       self.helper(costs, amount + costs[index][1], index + 1, 2))

        if color == 2:  # blue
            return min(self.helper(costs, amount + costs[index][2], index + 1, 1),
                       self.helper(costs, amount + costs[index][2], index + 1, 0))