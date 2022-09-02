# Recursive Paint House

# Time Complexity: O(3 * 2^n)

# Space Complexity: O(3 * 2^n) ~ Tree with 2^n nodes for the 3 choices of colors

# In this approach, we compute the minimum of the tree nodes below the first choices, and finally choose the minimum between the 3 paths

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if costs is None or len(costs) == 0:
            return 0
        caseR = self.helper(costs, 0, 0, 0)
        caseB = self.helper(costs, 0, 1, 0)
        caseG = self.helper(costs, 0, 2, 0)
        
        return min(caseR, min(caseB, caseG))
    
    def helper(self, costs: List[List[int]], r: int, color: int, minCost: int) -> int:
        
        # Base Case
        if r == len(costs):
            return minCost
        # Choosing a Color Case
        
        if (color == 0):
            return min(self.helper(costs, r+1, 1, minCost + costs[r][0]),
                      self.helper(costs, r+1, 2, minCost + costs[r][0]))
        if (color == 1):
            return min(self.helper(costs, r+1, 0, minCost + costs[r][1]),
                      self.helper(costs, r+1, 2, minCost + costs[r][1]))
        if (color == 2):
            return min(self.helper(costs, r+1, 0, minCost + costs[r][2]),
                      self.helper(costs, r+1, 1, minCost + costs[r][2]))
        
        return 99999
