"""
Time Complexity: O(n)
Space Complexity:O(1)
Did your code run on leetcode?:yes
Issues faced:
"""
class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        dp = [0,0,0]
        for i in range(len(costs)):
            dp0 = costs[i][0] + min(dp[1] ,dp[2])
            dp1 = costs[i][1] + min(dp[0] , dp[2])
            dp2 = costs[i][2] + min(dp[0] , dp[1])
            dp = [dp0,dp1,dp2]
        return min(dp)
        
