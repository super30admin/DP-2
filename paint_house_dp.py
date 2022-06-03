# Time Complexity : O(n) where n is number of houses
# Space Complexity : O(1) where n is range of the amount
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        n = len(costs)
        costR, costG, costB = costs[n-1][0], costs[n-1][1], costs[n-1][2]
        
        for house in range(n-2, -1, -1):
            tempR = costR
            tempG = costG

            costR = min(costs[house][0] + costG, costs[house][0] + costB)
            costG = min(costs[house][1] + tempR, costs[house][1] + costB)
            costB = min(costs[house][2] + tempR, costs[house][2] + tempG)
            
        return min(costR, costG, costB)