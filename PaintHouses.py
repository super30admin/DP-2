#Time Complexity : O(n) where n is the length of input array i.e. number of houses
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if costs is None or len(costs) == 0:
            return 0

        #dp = [[0 for _ in range(len(costs[0]))] for _ in range(len(costs))]
        #dp[0] = costs[0]

        for i in range(1, len(costs)):
            costs[i][0] = costs[i][0] + min(costs[i-1][1], costs[i-1][2])
            costs[i][1] = costs[i][1] + min(costs[i-1][0], costs[i-1][2])
            costs[i][2] = costs[i][2] + min(costs[i-1][0], costs[i-1][1])

        return min(costs[len(costs)-1][0], costs[len(costs)-1][1], costs[len(costs)-1][2])
