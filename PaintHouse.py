# TC: O(m x n) n = 3 so can be O(m)
# SC: O(1)
# LeetCode: Y(https://leetcode.com/problems/paint-house/)
# Approach: Convert an overlapping problem of repeating sub-problems into dp
#           Start from the above and at each element in the matrix store the best answer by selecting current color and minimum among the options in the top row

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        
        # edge case
        if not costs or not len(costs):
            return 0
        
        # Loop from the 1st row: skip 0th row
        for current_row in range(1,len(costs)):
            # select the minimum of two options available for each color
            costs[current_row][0] += min(costs[current_row - 1][1], costs[current_row - 1][2])
            costs[current_row][1] += min(costs[current_row - 1][0], costs[current_row - 1][2])
            costs[current_row][2] += min(costs[current_row - 1][0], costs[current_row - 1][1])
         
        # return the min of the options in the last row
        return min(costs[-1][0] , min(costs[-1][1], costs[-1][2]))
                
