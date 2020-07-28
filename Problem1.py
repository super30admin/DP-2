## Problem1(https://leetcode.com/problems/paint-house/)

# Time Complexity : O(n)
# Space Complexity : O(n) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

#Approach: Using a dp matrix, for each houses, we keep track of optimal cost of painting the house

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        
        if costs== None or len(costs)==0:
            return 0
        paintCosts = [[0 for i in range(len(costs[0]))] for j in range(len(costs))]

        paintCosts[0][0] = costs[0][0]

        paintCosts[0][1] = costs[0][1]

        paintCosts[0][2] = costs[0][2]

        for i in range(1, len(costs)):

            paintCosts[i][0] = costs[i][0] + min(paintCosts[i - 1][1], paintCosts[i - 1][2])

            paintCosts[i][1] = costs[i][1] + min(paintCosts[i - 1][0], paintCosts[i - 1][2])

            paintCosts[i][2] = costs[i][2] + min(paintCosts[i - 1][0], paintCosts[i - 1][1])

        return min(paintCosts[-1])
        