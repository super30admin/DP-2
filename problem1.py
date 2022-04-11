'''https://leetcode.com/problems/paint-house/


'''

# Time Complexity : O(N*M) where N is len(coins) and M = amount
# Space Complexity : O(N*M) where N is len(coins) and M = amount
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution:
    def minCost(self, costs: 'list[list[int]]') -> int:
        if costs is None or len(costs) == 0: return 0

        for i in range(len(costs)-2, -1, -1):
            costs[i][0] = min(costs[i+1][1], costs[i+1][2])
            costs[i][1] = min(costs[i+1][0], costs[i+1][2])
            costs[i][2] = min(costs[i+1][1], costs[i+1][1])
        
        return min(costs[0][0], min(costs[0][1], costs[0][2]))

