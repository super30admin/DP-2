'''
TD Soln: TC: O(n) SC: O(1)
Intuition: Current choice depends on prev choice
'''
class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        
        houses = len(costs)
        if not houses:
            return 0
        dp = [costs[0][x] for x in range(3)]
        
        for i in range(1, houses):
            newdp = [0 for x in range(3)]
            for x in range(3):
                newdp[x] = costs[i][x] + min(dp[x-1], dp[x+1 if x + 1 < 3 else 0])
            dp = newdp
        
        return min(dp)
        

