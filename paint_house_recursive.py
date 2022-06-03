# Time Complexity : O(2^n) where n is number of houses
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : No (Time Limit Exceeded)
# Any problem you faced while coding this : No

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        
        if len(costs) == 0: return 0
        
        caseR = self.minCostHelper(costs, 0, 0, 0)
        caseG = self.minCostHelper(costs, 0, 0, 1)
        caseB = self.minCostHelper(costs, 0, 0, 2)
        
        
        return min(caseR, caseG, caseB)
        
        
    
    def minCostHelper(self, costs, minCost, house, color):
        #Base
        if house == len(costs): return minCost
        
        #logic
        if color == 0:
            return min(
                self.minCostHelper(costs, minCost + costs[house][color], house + 1 , 1),
                self.minCostHelper(costs, minCost + costs[house][color], house + 1 , 2))
        
        if color == 1:
            return min(
                self.minCostHelper(costs, minCost + costs[house][color], house + 1 , 0),
                self.minCostHelper(costs, minCost + costs[house][color], house + 1 , 2))
        
        if color == 2:
            return min(
                self.minCostHelper(costs, minCost + costs[house][color], house + 1 , 0),
                self.minCostHelper(costs, minCost + costs[house][color], house + 1 , 1))