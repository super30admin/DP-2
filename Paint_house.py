# Time complexity - O(n)
# Space complexity - O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        
        # costs[i][j] is the house and j is the color of the house
        
        dp = [0, 0, 0]
        
        for i in range(len(costs)):
            # red
            dp0 = costs[i][0] + min(dp[1], dp[2])
            #Green
            dp1 = costs[i][1] + min(dp[0], dp[2])
            #Blue
            dp2 = costs[i][2] + min(dp[0], dp[1])
            
            dp = [dp0, dp1, dp2]
        return min(dp)
