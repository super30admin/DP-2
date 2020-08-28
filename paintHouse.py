# // Time Complexity : O(n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

# // Your code here along with comments explaining your approach
class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        
        if len(costs)==0:
            return 0
        
        # the values at 0th index don't have an option for choose/don't choose so we start from 1st index; we keep updating the values at the current index by adding the current price of color to the minimum of the other two prices of color at previous index (as two adjacent houses can't be painted with same color)

        for i in range(1, len(costs)):
            costs[i][0] += min(costs[i-1][1], costs[i-1][2])
            costs[i][1] += min(costs[i-1][0], costs[i-1][2])
            costs[i][2] += min(costs[i-1][0], costs[i-1][1])
            
        # return the minimum of the calculated value at pur last index
        return min(costs[len(costs)-1][0], min(costs[len(costs)-1][1], costs[len(costs)-1][2]))
        