# Time Complexity : O( k *  2 ^ n) [n = number of houses, k = number of colors]
# 
# Space Complexity : O(2 ^ n) [n = number of houses]
# 
# Did this code successfully run on Leetcode : Partially(TLE)
# 
# Any problem you faced while coding this : No
#
# Problem Approach:
# 1. Start with house 0 and find the cost of painting by each color.
# 2. The color chosen for the current house is not available for the next house. 
# 3. So we check which color was chosen -> increment the house number and pass other two color choices 
class Solution:
    def minCostUtil(self, costs, house, color, cost):
        if house >= len(costs):
            return cost
        # based on the color chosen for the current house
        # the color choice option for next house is decided
        if 0 == color:
            case_1 = self.minCostUtil(costs, house+1, 1, cost+costs[house][color])
            case_2 = self.minCostUtil(costs, house+1, 2, cost+costs[house][color])
        if 1 == color:
            case_1 = self.minCostUtil(costs, house+1, 0, cost+costs[house][color])
            case_2 = self.minCostUtil(costs, house+1, 2, cost+costs[house][color])
        if 2 == color:
            case_1 = self.minCostUtil(costs, house+1, 0, cost+costs[house][color])
            case_2 = self.minCostUtil(costs, house+1, 1, cost+costs[house][color])
        return min(case_1, case_2)
    
    def minCost(self, costs: List[List[int]]) -> int:
        if not costs: return 0
        min_cost = float(inf)
        for i in range(len(costs[0])):
            # All three colors choices are explored for coloring the first house
            min_cost = min(min_cost, self.minCostUtil(costs, 0, i, 0))
        return min_cost