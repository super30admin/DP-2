class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if len(costs)==0 or costs is None:
            return 0
        cr = costs[len(costs)-1][0]
        cg = costs[len(costs)-1][1]
        cb = costs[len(costs)-1][2]
        for i in range(len(costs)-2,-1,-1):
            tempr=cr
            tempg=cg
            cr=costs[i][0]+ min(cg,cb)
            cg=costs[i][1]+ min(tempr,cb)
            cb=costs[i][2]+ min(tempr,tempg)
            
        return min(cr,min(cg,cb))
        