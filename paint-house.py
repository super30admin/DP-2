# Time Complexity: O(n)
# Space Complexity: O(1)
class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if costs==None or len(costs)==0: return 0
        n=len(costs)
        cR=costs[n-1][0]
        cG=costs[n-1][1]
        cB=costs[n-1][2]
        
        for i in range(n-2,-1,-1):
            tempCR=cR
            tempCG=cG
            tempCB=cB
            cR=costs[i][0]+min(tempCG,tempCB)
            cG=costs[i][1]+min(tempCR,tempCB)
            cB=costs[i][2]+min(tempCG,tempCR)
        return min(cR,cG,cB)