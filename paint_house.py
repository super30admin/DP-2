# time complexity: O(N)
# space complexity: O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        a, b, c = 0, 0, 0
        for i in range(len(costs) - 1, -1, -1):
            a, b, c = costs[i][0] + min(b, c), costs[i][1] + min(a, c), costs[i][2] + min(a, b)

        return  min(a, b, c)