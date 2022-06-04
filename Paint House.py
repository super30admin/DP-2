"""
TC: O(n x m)
SC: O(m)
"""

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        cost = [ i for i in costs[0]]
        
        for row in range(1, len(costs)):
            n0 = costs[row][0] + min(cost[2], cost[1])
            n1 = costs[row][1]  + min(cost[2], cost[0])
            n2 = costs[row][2]  + min(cost[1], cost[0])
            cost=[n0,n1,n2]
        
        return min(cost)
