# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :


# Your code here along with comments explaining your approach


class Solution:
    def minCost(self, costs: List[List[int]]) -> int:

        if len(costs) == 0:
            return 0

        return min(self.minCost__(costs))

    def minCost__(self, costs):

        if len(costs) == 1:
            return costs[0]

        p = self.minCost__(costs[:-1])
        c = costs[-1]
        return [c[0] + min(p[1], p[2]),
                c[1] + min(p[0], p[2]),
                c[2] + min(p[0], p[1])]
