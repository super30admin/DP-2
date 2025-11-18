class Solution:
    #Time complexity O(n)
    def minCost(self, costs):  # 0-R, 1-B, 2-G
        n = len(costs) #rows of houses
        m = len(costs[0]) #cols of diff colors
        dp = [[0] * n for _ in range(m)]

        dp[n-1][0] = costs[n-1][0] #starting bottom up last red house
        dp[n-1][1] = costs[n-1][1] #last blue house
        dp[n-1][2] = costs[n-1][2] #last green house

        for i in range (n-2, -1, 1):
            dp[i][0] = costs[i][0] + min(dp[i+1][1], dp[i+1][2]) #
            dp[i][1] = costs[i][1] + min(dp[i+1][0], dp[i+1][2])
            dp[i][2] = costs[i][2] + min(dp[i+1][0], dp[i+1][1])
        re = min(dp[0][0], dp[0][1], dp[0][2])
        return re

