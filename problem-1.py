#TimeComplexity: O(n)
#spacecomplexity: O(1)
class Solution:
    def minCost(self,costs: List[List[int]]) -> int:
        n = len(costs)
        dp = [[0]*3]*n
        
        for j in range(0,3):
            dp[n-1][j] = costs[n-1][j]
        
        for i in range(n-2,0,-1):
            dp[i][0] = costs[i][0] + min(dp[i+1][1]+dp[i+1][2])
            dp[i][1] = costs[i][1] + min(dp[i+1][0]+dp[i+1][2])
            dp[i][2] = costs[i][2] + min(dp[i+1][1]+dp[i+1][0])
        
        return min (dp[0][0],min(dp[0][1], dp[0][2]))