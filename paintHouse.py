# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach: Start from the last house. For each house, add its cost to the minimum of the other two colors.
# Return the minimum final cost.

class Solution:
    def minCost(self, costs):
        if not costs:
            return 0
        r, g, b = costs[-1]   
        for i in range(len(costs) - 2, -1, -1):
            nr = costs[i][0] + min(g, b)
            ng = costs[i][1] + min(r, b)
            nb = costs[i][2] + min(r, g)
            r, g, b = nr, ng, nb

        return min(r, g, b)
