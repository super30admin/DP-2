#TC - O(N)
#SC - O(1)
class Solution:
    def minCost(self, costs):
        dp = [0,0,0]
        n = len(costs)
        for i in range(n):
            r = costs[i][0] + min(dp[1],dp[2])
            g = costs[i][1] + min(dp[0],dp[2])
            b = costs[i][2] + min(dp[1],dp[0])
            dp = [r,g,b]
        return min(dp)
        

            