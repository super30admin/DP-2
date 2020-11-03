class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if len(costs) == 0:
            return 0
        
        m = len(costs[0])
        n = len(costs)
        
        #dp=[[0 for j in range(m)] for i in range(n)]
        cB = costs[0][0]
        cG = costs[0][1]
        cR = costs[0][2]
        
        for i in range(1,n):
            tempB = cB
            tempG = cG
            cB = costs[i][0] + min(cG , cR)
            cG = costs[i][1] + min(tempB , cR)
            cR = costs[i][2] + min(tempB , tempG)
        
        return min(cB,cG,cR)
        
        
'''
class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if len(costs) == 0:
            return 0
        
        m = len(costs[0])
        n = len(costs)
        
        #dp=[[0 for j in range(m)] for i in range(n)]
        
        for i in range(1,n):
            costs[i][0] = costs[i][0] + min(costs[i-1][1] , costs[i-1][2])
            costs[i][1] = costs[i][1] + min(costs[i-1][0] , costs[i-1][2])
            costs[i][2] = costs[i][2] + min(costs[i-1][1] , costs[i-1][0])
        
        return min(costs[n-1][0],costs[n-1][1],costs[n-1][2])
'''