class Solution:
    def minCost(self,costs):
        dp=[0,0,0]
        for i in range(len(costs)):
            dp0=dp[i][0] + min(dp[i][1],dp[i][2])
            dp1=dp[i][1] + min(dp[i][0],dp[i][2])
            dp2=dp[i][2] + min(dp[i][0],dp[i][1])

            dp=[dp0,dp1,dp2]
        
        return min(dp)
    

