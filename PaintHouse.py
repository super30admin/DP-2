#Time Complexity: O(n)
#Space Complexity: O(n)
class Solution:
    def minCost(self, costs):
        n = len(costs)
        dp = [[0]*3 for i in range(n+1)]

        for i in range(1,n+1):
            dp[i][0] = costs[i-1][0] + min(dp[i-1][1], dp[i-1][2])
            dp[i][1] = costs[i-1][1] + min(dp[i-1][0], dp[i-1][2])
            dp[i][2] = costs[i-1][2] + min(dp[i-1][0], dp[i-1][1])
        re = min(dp[n][0], dp[n][1], dp[n][2])
    
        return re 
