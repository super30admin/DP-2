"""Approach 1:
We can't use greedy approach on each row, that doesn't give us optimal solution.
So we use Exhaustive approach. We explore 3 paths, starting from Red, Blue and Green
in the first row, and build a tree from there. Recursively we find costs for each
of such exhaustive tree and return minimum of all 3.

TC O(3^n)
SC whatever used by Recursion stack to explore all the paths
"""

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if len(costs) == 0 or not costs:
            return
        
        # we have 3 cases, if we start with red, blue or green
        # and construct the tree from there
        
        case1 = self.helper(costs, 0, 0, 0)
        case2 = self.helper(costs, 0, 1, 0)
        case3 = self.helper(costs, 0, 2, 0)
        
        return min(case1, case2, case3)
    
    def helper(self, costs, row, color, costs_so_far):
        # base 
        if row >= len(costs):
            return costs_so_far
        # logic
        if color == 0:
            return min(
                self.helper(costs, row + 1, 1, costs_so_far + costs[row][0]),
                self.helper(costs, row + 1, 2, costs_so_far + costs[row][0]),
            )
        elif color == 1:
            return min(
                self.helper(costs, row + 1, 0, costs_so_far + costs[row][1]),
                self.helper(costs, row + 1, 2, costs_so_far + costs[row][1]),
            )
        else:
            return min(
                self.helper(costs, row + 1, 0, costs_so_far + costs[row][2]),
                self.helper(costs, row + 1, 1, costs_so_far + costs[row][2]),
            )

"""Approach2:
Strting from 2nd last row in matrix, start modifying matrix to add min of costs from row below 
for each color we choose.

TC O(n) where n is number of houses
SC O(1) as we don't create new array
"""
class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if len(costs) == 0 or not costs:
            return
        
        # we can modify the costs matrix from 2nd last row to up
        # and top row min value will give us our answer
        
        for i in range(len(costs)-2, -1, -1):
            costs[i][0] += min(costs[i+1][1], costs[i+1][2])
            costs[i][1] += min(costs[i+1][0], costs[i+1][2])
            costs[i][2] += min(costs[i+1][0], costs[i+1][1])
            
        
        return min(costs[0])

