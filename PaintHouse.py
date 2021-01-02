# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Can't check as I don't have premium
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Used Dynamic Programming as to optimize the repeated subproblems


class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if len(costs) == 0:
            return 0
        if len(costs) == 1:
            return min(costs[0])
        for i in range(len(costs) - 1, -1, -1):
            costs[i - 1][0] += min(costs[i][1], costs[i][2])
            costs[i - 1][1] += min(costs[i][0], costs[i][2])
            costs[i - 1][2] += min(costs[i][0], costs[i][1])

        return min(costs[0])
