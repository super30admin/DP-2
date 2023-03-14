# Time Complexity : O(n)
# Space Complexity : O(n)

from typing import List
class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        n = len(costs)
        
        # Initialize dp array with the same values as costs
        dp = [[0]*3 for _ in range(n)]
        dp[0] = costs[0]
        
        # Iterate over the houses and update dp array
        for i in range(1, n):
            dp[i][0] = costs[i][0] + min(dp[i-1][1], dp[i-1][2])
            dp[i][1] = costs[i][1] + min(dp[i-1][0], dp[i-1][2])
            dp[i][2] = costs[i][2] + min(dp[i-1][0], dp[i-1][1])
        
        # Return the minimum cost of painting the last house
        return min(dp[n-1])
