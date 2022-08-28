# Time Complexity: O(m*n)
# Space Complexity: O(m*n)

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if len(costs) == 0 or costs is None:
            return 0
        n = len(costs)
        # print(n)
        dp = [[0 for j in range(3) ] for i in range(n)]  #[[0,0,0], [0,0,0], [0,0,0]]
        
        for j in range(0, 3):
            # print(n)
            dp[n-1][j] = costs[n-1][j]
            
        for i in range(n-2, -1, -1):
            dp[i][0] = costs[i][0] + min(dp[i+1][1], dp[i+1][2])
            dp[i][1] = costs[i][1] + min(dp[i+1][0], dp[i+1][2])
            dp[i][2] = costs[i][2] + min(dp[i+1][1], dp[i+1][0])
            
        return min(dp[0][0], min(dp[0][1], dp[0][2]))