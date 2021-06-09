"""

Time Complexity :  O(n) where n is number of houses.
Space Complexity : O(1)
    
"""

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if not costs or len(costs) == 0: return 0 
        
        last_row = len(costs) - 1 
        
        pred = costs[last_row][0]
        pgreen = costs[last_row][1]
        pblue = costs[last_row][2]
        
        for i in range(len(costs)-2, -1, -1):
            pr = pred
            pg = pgreen
            pb = pblue 
            
            pred = costs[i][0] + min(pg, pb)
            pgreen = costs[i][1] + min(pr, pb)
            pblue = costs[i][2] + min(pr, pg)
        
        return min(pred, pgreen, pblue)