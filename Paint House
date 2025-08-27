class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if not costs:
            return 0
        for n in reversed(range(len(costs) - 1)):
            # Total cost of painting nth house red.
            costs[n][0] += min(costs[n + 1][1], costs[n + 1][2])
            # Total cost of painting nth house green.
            costs[n][1] += min(costs[n + 1][0], costs[n + 1][2])
            # Total cost of painting nth house blue.
            costs[n][2] += min(costs[n + 1][0], costs[n + 1][1])

        return min(costs[0])  # Return the minimum in the first row.