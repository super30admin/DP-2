class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if (costs==[]):
            return 0
        cr=costs[len(costs)-1][0]
        cb=costs[len(costs)-1][1]  
        cg=costs[len(costs)-1][2]
        i=len(costs)-2
        while(i>=0):
            prevr=cr
            prevb=cb
            cr=costs[i][0]+min(cb,cg)
            cb=costs[i][1]+min(prevr,cg)
            cg=costs[i][2]+min(prevr,prevb)
            i-=1
        return min(cr,cb,cg)