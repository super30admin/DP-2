# Time Complexity: O(n)
# Space Complexity: O(n)

class Solution:
    def minCost(self, costs: list[list[int]]) -> int:
        if costs == None or len(costs) == 0:
            return -1
        
        n = len(costs) # number of houses (rows)
        m = len(costs[0]) # colors (columns)

        dp = [[0 for i in range(m)] for j in range(n)]
        #print(dp)
        dp[0][0] = costs[0][0]
        dp[0][1] = costs[0][1]
        dp[0][2] = costs[0][2]
        
        # going from top to bottom of matrix
        for i in range(1,n):
            dp[i][0] = costs[i][0] + min(dp[i-1][1],dp[i-1][2])
            dp[i][1] = costs[i][1] + min(dp[i-1][0],dp[i-1][2])
            dp[i][2] = costs[i][2] + min(dp[i-1][0],dp[i-1][1])
        
        return min(dp[n-1][0],dp[n-1][1],dp[n-1][2])