class Solution(object):    #Bottom-UP DP approach
    def minCost(self, costs):
        if not costs:
            return 0

        n = len(costs)

        for i in range(1, n):
            # Paint current house red → prev house can be blue or green
            costs[i][0] += min(costs[i - 1][1], costs[i - 1][2])
            # Paint current house blue → prev house can be red or green
            costs[i][1] += min(costs[i - 1][0], costs[i - 1][2])
            # Paint current house green → prev house can be red or blue
            costs[i][2] += min(costs[i - 1][0], costs[i - 1][1])

        # Return min cost among all color choices for the last house
        return min(costs[n - 1])