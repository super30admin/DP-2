class Solution:
    def minCost(self,costs:List[List[int]]) -> int:
        dp = [0,0,0]

        for i in range(len(costs)):
            dp0 = cost[i][0] + min(dp[1],dp[2])
            dp1 = cost[i][1] + min(dp[0],dp[2])
            dp2 = cost[i][2] + min(dp[0],dp[1])
            dp = [dp0,dp1,dp2]
            