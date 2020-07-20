# Leetcode 256. Paint House

# Time Complexity :  O(n) where n is the size of the array

# Space Complexity : O(1)

# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach: To find the minimum value use the current value plus the least cost from the remaining
# 2 colors from the previous house. Compute the same for all the cases starting with different color
# and return the least of the values in the last row

# Your code here along with comments explaining your approach

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        # case 1:
        if costs == None or len(costs) == 0:
            return 0

        for i in range(1, len(costs)):
            # case 1: Starting with red
            costs[i][0] = costs[i][0] + min(costs[i-1][1], costs[i-1][2])
            # case 2: Starting with green
            costs[i][1] = costs[i][1] + min(costs[i-1][0], costs[i-1][2])
            # case 3: Starting with blue
            costs[i][2] = costs[i][2] + min(costs[i-1][1], costs[i-1][0])

        return min(costs[len(costs)-1][0], costs[len(costs)-1][1], costs[len(costs)-1][2])
