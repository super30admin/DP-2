"""
Time Complexity : O(2^n)
Space Complexity : O(n)
Did this code successfully run on Leetcode : Time Limit Exceeded
Any problem you faced while coding this : No
"""
class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if len(costs) == 0:
            return 0
        case1 = self.helper(costs, 0, 0, 0)
        case2 = self.helper(costs, 0, 1, 0)
        case3 = self.helper(costs, 0, 2, 0)
        return min(case1, case2, case3)
    def helper(self, costs: List[List[int]], row: int, color: int, minCost):
        # Base case
        if row == len(costs):
            return minCost
        # Logic 
        if color == 0:
            return min(self.helper(costs, row + 1, 1, minCost + costs[row][0]),                              self.helper(costs, row + 1, 2, minCost + costs[row][0]))
        if color == 1:
            return min(self.helper(costs, row + 1, 0, minCost + costs[row][1]),                              self.helper(costs, row + 1, 2, minCost + costs[row][1]))
        return min(self.helper(costs, row + 1, 0, minCost + costs[row][2]),                              self.helper(costs, row + 1, 1, minCost + costs[row][2]))
    