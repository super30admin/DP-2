'''
TD Soln: TC: O(n) SC: O(n)
'''
class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        
        houses = len(costs)
        if not houses:
            return 0
        dp = [[-1 for j in range(3)] for i in range(houses)]
        
        def rec(idx, prev, houses, dp):
            if idx == houses:
                return 0
            if dp[idx][prev] != -1:
                return dp[idx][prev]
            
            minm = float("INF")
            for color in range(3):
                if color == prev:
                    continue
                minm = min(minm, costs[idx][color] + rec(idx + 1, color, houses, dp))
            dp[idx][prev] = minm
            return dp[idx][prev]
        
        return rec(0, -1, houses, dp)
        