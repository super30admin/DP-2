# Time Complexity : O(n), where n is the number of houses
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        r, b, g = costs[0][0], costs[0][1], costs[0][2]

        for i in range(1, len(costs)):
            tempr, tempb, tempg = r, b, g

            r = min(costs[i][0] + tempb, costs[i][0] + tempg)
            b = min(costs[i][1] + tempr, costs[i][1] + tempg)
            g = min(costs[i][2] + tempr, costs[i][2] + tempb)

        return min(r, b, g)
