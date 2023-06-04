from typing import List

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if len(costs) == 0: return 0
        rows = len(costs)

        if len(costs) > 1:
            for r in range(1, rows):
                costs[r][0] = min(costs[r][0] + costs[r-1][1], costs[r][0] + costs[r-1][2])
                costs[r][1] = min(costs[r][1] + costs[r-1][0], costs[r][1] + costs[r-1][2])
                costs[r][2] = min(costs[r][2] + costs[r-1][0], costs[r][2] + costs[r-1][1])
        
        return min(costs[-1])