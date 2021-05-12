# Time Complexity: O(n) where n is the no of houses
# Space Complexity: O(1)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

# Solution:

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if not costs or len(costs) == 0:
            return 0

        # If not allowed to mutate the same array - use 3 variables to store cost of 3 colors
        cr = costs[len(costs) - 1][0]
        cb = costs[len(costs) - 1][1]
        cg = costs[len(costs) - 1][2]

        # Using bottom up approach, update the min cost of painting all houses with the 3 possible colors
        for i in range(len(costs) - 2, -1, -1):
            tempr, tempb = cr, cb
            cr = costs[i][0] + min(cb, cg)
            cb = costs[i][1] + min(tempr, cg)
            cg = costs[i][2] + min(tempr, tempb)

        return min(cr, min(cb, cg))