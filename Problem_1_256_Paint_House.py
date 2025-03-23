class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        dp = [[float('inf') for i in range(len(costs))] for j in range(3)]

        for i in range(3):
            dp[i][0] = costs[0][i]

        for house in range(1, len(costs)):
            # update the dp matrix
            dp[0][house] = costs[house][0] + min(dp[1][house - 1], dp[2][house - 1])
            dp[1][house] = costs[house][1] + min(dp[0][house - 1], dp[2][house - 1])
            dp[2][house] = costs[house][2] + min(dp[0][house - 1], dp[1][house - 1])

        return min(dp[0][-1], dp[1][-1], dp[2][-1])


