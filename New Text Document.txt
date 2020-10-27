#timecomplexity O(n)
#space complexity O(1)
#Desc

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if costs==[]: return 0
        _len=len(costs)
        cr=0
        cb=0
        cg=0
        for i in range(0,len(costs)):
 
            cr=costs[i][0]+min(cb,cg)
            cb=costs[i][1]+min(tempcr,cg)
            cg=costs[i][2]+min(tempcr,tempcb)
            
        return min(cr,cb,cg)
        