"""

Time Complexity : O(3*2^n) where n is number of houses.
Space Complexity : O(n)
    
"""

class Solution:
    def helper(self, costs, minc, color, row):
        if row == len(costs):
            return minc 
        
        if color == 0: 
            return min(self.helper(costs, minc + costs[row][color], 1, row + 1), self.helper(costs, minc + costs[row][color], 2, row + 1 ))
        if color == 1: 
            return min(self.helper(costs, minc + costs[row][color], 0, row + 1), self.helper(costs, minc + costs[row][color], 2, row + 1 ))
        if color == 2: 
            return min(self.helper(costs, minc + costs[row][color], 0, row + 1), self.helper(costs, minc + costs[row][color], 1, row + 1 ))
        
        
    def minCost(self, costs: List[List[int]]) -> int:
        if not costs or len(costs) == 0:
            return 0 
        
        if len(costs) == 1:
            return min(costs)
        
        caseR = self.helper(costs, 0, 0, 0)
        caseG = self.helper(costs, 0, 1, 0)
        caseB = self.helper(costs, 0, 2, 0)
        
        return min(caseR, caseG, caseB)
        