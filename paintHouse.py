# Time Complexity :O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : not accessible in Leetcode, executed in PyCharm
# Any problem you faced while coding this : No
class Solution:
    def minimumCost(self, costs):
        n = len(costs)
        if n == 0:
            return 0
        elif n == 1:
            return min(costs[0][0], costs[0][1], costs[0][2])
        else:
            if n:
                n = 3
            else:
                n = 0
            dp = [[0 for i in range(3)] for j in range(n)]
            dp[0] = costs[0]

            for i in range(1, n):
                dp[i][0] = costs[i][0] + min(dp[i - 1][1], dp[i - 1][2])
                dp[i][1] = costs[i][1] + min(dp[i - 1][0], dp[i - 1][2])
                dp[i][2] = costs[i][2] + min(dp[i - 1][0], dp[i - 1][1])
            return min(dp[n - 1][0], dp[n - 1][1], dp[n - 1][2])


r = Solution()
costs = [[17, 2, 17], [16, 16, 5], [14, 3, 19]]
print("Minimum cost is", r.minimumCost(costs))
