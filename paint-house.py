# We use dynamic programming to find the minimum cost to paint all houses.
# We initialize a dp array where dp[i] represents the minimum cost to paint house i, starting with dp[0] = costs[0].
# For each house, we update the dp array by taking the minimum of the current value and the value of the amount minus the house value plus the amount of money in the previous house.

# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if not costs:
            return 0
        for i in range(1, len(costs)):
            costs[i][0] += min(costs[i-1][1], costs[i-1][2])  # Paint red
            costs[i][1] += min(costs[i-1][0], costs[i-1][2])  # Paint blue
            costs[i][2] += min(costs[i-1][0], costs[i-1][1])  # Paint green
        return min(costs[-1])
        