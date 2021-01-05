# Time Complexity: O(num_houses * num_colours)
# Space Complexity: O(1)
# Accepted on leetcode
class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        
        if not costs:
            return 0
        
        # Update the min cost going bottom up for each colour
        # Begin calculating from second last row by taking min from las row and add to current row's value. Update value in place
        for r in range(len(costs)-2, -1, -1):

            # for red colour
            costs[r][0] += min(costs[r+1][1], costs[r+1][2])
            
            # for green colour
            costs[r][1] += min(costs[r+1][0], costs[r+1][2])
            
            # for blue colour
            costs[r][2] += min(costs[r+1][1], costs[r+1][0])
            
        return min(costs[0])