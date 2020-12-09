'''
Time complexity :O(N)
Space complexity :O(1)
'''
class Solution(object):
    def minCost(self, costs):
        if not costs:
            return 0

        for i, cost in enumerate(costs[1:], 1):
            costs[i][0] = min(costs[i-1][1], costs[i-1][2]) + cost[0]
            costs[i][1] = min(costs[i-1][0], costs[i-1][2]) + cost[1]
            costs[i][2] = min(costs[i-1][0], costs[i-1][1]) + cost[2]
            
        return min(costs[-1])

print(Solution().minCost([[17,2,17],[16,16,5],[14,3,19]]))