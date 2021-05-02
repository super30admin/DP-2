"""Paint House 
Time Complexity : O(n)
Space Complexity: O(1)

Approach -> optimized dynamic programming """
class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if(costs == None or len(costs) == 0):
            return 0
        n = len(costs)
        cR = costs[0][0] #choose R
        cB = costs[0][1] # choose blue
        cG = costs[0][2] #choose green
        
        for i in range(1,n):
            tempR = cR 
            tempB = cB
            
            cR = costs[i][0] + min(cB, cG) 
            cB = costs[i][1] + min(tempR,cG)
            cG = costs[i][2] + min(tempR,tempB)
        
        return min(cR,min(cB, cG))