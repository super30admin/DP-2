##Time Complexity : O(n)
##Space Complexity :O(1)
##Did this code successfully run on Leetcode : Yes
class Solution(object):
    def minCost(self, costs):
        """
        :type costs: List[List[int]]
        :rtype: int
        """
        if not costs:
            return 0

        m = len(costs)
        n = 3 

        for i in range(1, m):
            costs[i][0] = min(costs[i-1][1], costs[i-1][2]) + costs[i][0]
            costs[i][1] = min(costs[i-1][0], costs[i-1][2]) + costs[i][1]
            costs[i][2] = min(costs[i-1][0], costs[i-1][1]) + costs[i][2]

        return min(costs[-1])