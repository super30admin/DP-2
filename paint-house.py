# Time Complexity: O(n)
# Space ComplexityL O(1)

class Solution:
    def minCost(costs: List[List[int]]) -> int:
        if len(costs) == 0 or costs == None:
            return 0

        for i in range(1, len(costs)):
            costs[i][0] += min(costs[i - 1][1], costs[i - 1][2])
            costs[i][1] += min(costs[i - 1][0], costs[i - 1][2])
            costs[i][1] += min(costs[i - 1][0], costs[i - 1][1])

        return min(costs[-1][0], min(costs[-1][1], costs[-1][2]))