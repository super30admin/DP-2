# Time & space Complexity: o(n)
# leetcode successfully running : 40 ms ACCECPTED.
# costs[i][j] i is the house, j is the color
class Solution(object):
    def minCost(self, costs):
        """
        :type costs: List[List[int]]
        :rtype: int
        """

        dp = [0] * 3

        for i in range(0, len(costs)):
            tmp = [0] * 3
            for j in range(0, 3):
                if j == 0:
                    tmp[j] = costs[i][j] + min(dp[1], dp[2])
                if j == 1:
                    tmp[j] = costs[i][j] + min(dp[0], dp[2])
                if j == 2:
                    tmp[j] = costs[i][j] + min(dp[0], dp[1])

            dp = tmp

        return min(dp[0], dp[1], dp[2])
