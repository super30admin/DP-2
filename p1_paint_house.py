"""
// Time Complexity : O(N) N : number of houses
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

"""


class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        for i in range(len(costs) - 2, -1, -1):
            costs[i][0] += min(costs[i + 1][1], costs[i + 1][2])
            costs[i][1] += min(costs[i + 1][0], costs[i + 1][2])
            costs[i][2] += min(costs[i + 1][0], costs[i + 1][1])

        return min(costs[0][0], costs[0][1], costs[0][2])