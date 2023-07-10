class Solution:
    # Time complexity: O(n), where n is the number of houses (length of costs)
    # Space complexity: O(n), where n is the number of houses (length of costs)
    def minCost(self, costs):
        if not costs or len(costs) == 0:
            return 0

        dp = [[0] * 3 for _ in range(len(costs))]
        dp[0][0] = costs[0][0]
        dp[0][1] = costs[0][1]
        dp[0][2] = costs[0][2]

        for i in range(1, len(costs)):
            dp[i][0] = costs[i][0] + min(dp[i - 1][1], dp[i - 1][2])
            dp[i][1] = costs[i][1] + min(dp[i - 1][0], dp[i - 1][2])
            dp[i][2] = costs[i][2] + min(dp[i - 1][0], dp[i - 1][1])

        return min(dp[-1][0], dp[-1][1], dp[-1][2])
