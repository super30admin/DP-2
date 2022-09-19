#Painthouse
#tc:O(N)
def mincost(self,costs):
    #cost[i][j] i is for houses and j is for color
    dp = [0,0,0]#initializing base dp case
    for i in range(len(costs)):
        dp0= costs[i][0]+min(dp[1],dp[2])
        dp1 = costs[i][1]+min(dp[0],dp[2])
        dp2 = costs[i][2]+min(dp[0],dp[1])
        dp = [dp0,dp1,dp2]
    return min(dp)
