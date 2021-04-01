# Time Complexity: O(NC) N is the number of houses and C is the number of colors
# Space Complexity: O(C) 
# Passed Leetcode 

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        
        if len(costs) == 0:
            return 0
        
        if len(costs) == 1:
            return min(costs[0])
        
        for i in range(1, len(costs)):
            
            for j in range(len(costs[0])):
                
                prev = costs[i - 1][0:j] + costs[i - 1][j + 1:]
                costs[i][j] += min(prev)        
        return min(costs[-1])