class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        
        
        if len(costs)==0:
            return 0
        
        prev = costs[-1]
        for i in reversed(range(len(costs)-1)):
            
            curr = costs[i]
            
            curr[0]+= min(prev[1],prev[2])
            curr[1]+= min(prev[0],prev[2])
            curr[2]+= min(prev[0],prev[1])
            
            prev = curr
            

        return min(prev)
