# DP
# TC = SC = O(n) as number of colors is a constant
# Submitted successfully
class Solution(object):
    def minCost(self, costs):
        """
        :type costs: List[List[int]]
        :rtype: int
        """
        if len(costs) == 0 or costs == None:
            return 0

        # initializing dp 2D array
        dp = [[0 for i in range(3)] for j in range(len(costs))]

        # filling the last row of dp array same as costs array
        for k in range(3):
            dp[len(costs) - 1][k] = costs[len(costs) - 1][k]

        # print(dp)
        for m in range(len(costs) - 2, -1, -1):
            dp[m][0] = costs[m][0] + min(dp[m + 1][1], dp[m + 1][2])
            dp[m][1] = costs[m][1] + min(dp[m + 1][0], dp[m + 1][2])
            dp[m][2] = costs[m][2] + min(dp[m + 1][1], dp[m + 1][0])

        # least value achieved in the top row of dp array is our answer
        return min(dp[0])