class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        cols = len(costs[0])
        rows = len(costs)
        dp = [[0] * cols for _ in range(rows)]
        
        # base case
        dp[0] = costs[0]
        
        for i in range(1,rows):
            dp[i][0] = min(dp[i-1][1], dp[i-1][2]) + costs[i][0]
            dp[i][1] = min(dp[i-1][0], dp[i-1][2]) + costs[i][1]
            dp[i][2] = min(dp[i-1][0], dp[i-1][1]) + costs[i][2]
            
        return min(dp[-1])