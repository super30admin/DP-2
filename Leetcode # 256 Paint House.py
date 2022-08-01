# Time Complexity: O(n)
# Space Complexity: O(n)

class Solution:
    def minCost(costs):
        if costs is None or len(costs) == 0:
            return 0

        n = len(costs)
        for i in range(n-2, -1, -1):
            costs[i][0] = costs[i][0] + min(costs[i+1][1], costs[i+1][2])
            costs[i][1] = costs[i][1] + min(costs[i+1][0], costs[i+1][2])
            costs[i][2] = costs[i][2] + min(costs[i+1][1], costs[i+1][0])
            
        return min(costs[0][0], costs[0][1], costs[0][2])