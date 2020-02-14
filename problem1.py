# Time Complexity : O(n) (Where n is total houses)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english:
# - This can be solved using dynamic programming. At every house chose one color and from previous house chose minimum from available other two color. This way in the last house we will have value of minimum for given color choise.

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
#       Handle edge case
        if not costs:
            return 0
        
        ln = len(costs)
        
#       If only one house is given chose cheapest color.
        if ln == 1:
            return min(costs[0])
        
#       From second house run loop till the last house
        for i in range(1, ln):
#           For every color add it's cost and from previous house chose minimum cost from the two avilable color.
            costs[i][0] = costs[i][0] + min(costs[i-1][1], costs[i-1][2])
            costs[i][1] = costs[i][1] + min(costs[i-1][0], costs[i-1][2])
            costs[i][2] = costs[i][2] + min(costs[i-1][0], costs[i-1][1])
            
#       The last house will have min value for chosing corresponding color.
        return min(costs[ln-1])
