"""
There is a row of n houses, where each house can be painted one of three 
colors: red, blue, or green. The cost of painting each house with a certain 
color is different. You have to paint all the houses such that no two adjacent 
houses have the same color.

The cost of painting each house with a certain color is represented 
by an n x 3 cost matrix costs.

For example, costs[0][0] is the cost of painting house 0 with the 
color red; costs[1][2] is the cost of painting house 1 with color green, and so on...
Return the minimum cost to paint all houses.

"""

# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on leetcode : Yes
# Any problem you faced while coding this : No

from typing import List

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        
        if costs == None or not costs:
            return 0
        
        for i in range(len(costs)-2, -1,-1):
            costs[i][0] += min(costs[i+1][1], costs[i+1][2])
            costs[i][1] += min(costs[i+1][0], costs[i+1][2])
            costs[i][2] += min(costs[i+1][0], costs[i+1][1])
            
        return min(costs[0][0], min(costs[0][1], costs[0][2]))