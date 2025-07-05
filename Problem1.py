# Time Complexity:
# O(n)

# Space Complexity:
# O(n)
class Solution(object):
    def PaintHouse(self, costs):
        m = len(costs)
        n = len(costs[0])

        dp = [[0] * n for _ in range(m)]
        # first row will be same 
        dp[0][0] = costs[0][0]
        dp[0][1] = costs[0][1]
        dp[0][2] = costs[0][2]

        for i in range(1, m):
            dp[i][0] = costs[i][0] + min(dp[i-1][1], dp[i-1][2])
            dp[i][1] = costs[i][1] + min(dp[i-1][0], dp[i-1][2])
            dp[i][2] = costs[i][2] + min(dp[i-1][0], dp[i-1][1])

        return min(dp[m-1][0], dp[m-1][1], dp[m-1][2])