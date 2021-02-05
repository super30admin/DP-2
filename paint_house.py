# O(N) TIME AND O(1) SPACE WHERE N IS LEN(COSTS) 
class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if len(costs) == 0:
            return 0
        previousHouse = costs[0][:]
        for i in range(1,len(costs)):
            currentHouse = [None for i in range(3)]
            
            currentHouse[0] = costs[i][0] + min(previousHouse[1],previousHouse[2])
            
            currentHouse[1] = costs[i][1] + min(previousHouse[0],previousHouse[2])
            
            currentHouse[2] = costs[i][2] + min(previousHouse[0],previousHouse[1])
        
            previousHouse = currentHouse[:]
    
        return min(previousHouse)
            
            
        