# Time Complexity : C^H 
# Space Complexity : H
# Did this code successfully run on Leetcode : yes	
# Any problem you faced while coding this : Followed approach from the class 
class Solution:
    def minCost(self, costs):
        if not costs:
            return 0
        dp = [[float('inf')] * 3 for _ in costs]
        for i, cost in enumerate(costs):
            if i == 0:
                dp[i] = cost[:] 
                continue
            r, g, b = cost
            dp[i][0] = min(dp[i - 1][1], dp[i - 1][2]) + cost[0]
            dp[i][1] = min(dp[i - 1][0], dp[i - 1][2]) + cost[1]
            dp[i][2] = min(dp[i - 1][0], dp[i - 1][1]) + cost[2]
        return min(dp[-1])