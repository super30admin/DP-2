class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if costs==None or len(costs)==0:
            return 0
        dp= [[0 for x in range(3)] for y in range(len(costs))]
        for j in range(3):
            dp[len(costs)-1][j]=costs[len(costs)-1][j]
        for i in range(len(costs)-2,-1,-1):
            print(i)
            dp[i][0]=costs[i][0]+min(dp[i+1][1],dp[i+1][2])
            dp[i][1]=costs[i][1]+min(dp[i+1][0],dp[i+1][2])
            dp[i][2]=costs[i][2]+min(dp[i+1][1],dp[i+1][0])
            
        return min(dp[0][0],min(dp[0][1],dp[0][2]))
        