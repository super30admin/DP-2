#problem: 256. Paint House
# time: O(mn) here m is 3, n is the number of houses so it will be ->  O(n)
# space: O(mn)
class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if not costs:
            return 0

        m = len(costs) - 1

        dp = [[0] * 3 for _ in range(m + 1)]

        dp[m][0] = costs[m][0]
        dp[m][1] = costs[m][1]
        dp[m][2] = costs[m][2]

        for i in range(m - 1, -1, -1):
            dp[i][0] = costs[i][0] + min(dp[i + 1][1], dp[i + 1][2])
            dp[i][1] = costs[i][1] + min(dp[i + 1][0], dp[i + 1][2])
            dp[i][2] = costs[i][2] + min(dp[i + 1][0], dp[i + 1][1])

        return min(dp[0][0], min(dp[0][1], dp[0][2]))