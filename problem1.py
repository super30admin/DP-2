# Time Complexity : O(N),  
# Space Complexity :O(N), 

# Did this code successfully run on Leetcode : 
# No its not free 

# Any problem you faced while coding this : 

# Your code here along with comments explaining your approachclass Solution:


class Solution:
    def minCost(self, costs):

        if costs == None and len(costs) == 0:
            return 0
        n = len(costs)
        dp = [[0]*3]*n
        
        for i in range(3):
            dp[n-1][i] = costs[n-1[i]]
        for i in range(n-2,-1,-1):    
            dp[i][0] = costs[i][0] + min(dp[i+1][1], dp[i+1][2])
            dp[i][1] = costs[i][1] + min(dp[i+1][0], dp[i+1][2])
            dp[i][2] = costs[i][2] + min(dp[i+1][1], dp[i+1][0])
        return min(dp[0][0], dp[0][1],dp[0][2])   