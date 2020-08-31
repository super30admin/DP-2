"""
# 256 - Paint House

Time = O(nm); n = number of house, m = number of colors = 3(here)
space = 
Successfully excecuted on leetcode

Approach - 
At each row, compare with previous row and choose alternate coloumns so no adjacent house has same color

"""

#1. Constant space solution

class Paint:
    def minCost(costs):
        if len(costs) == 0:
            return 0
        
        for i in range(1,len(costs)):
            costs[i][0] += min(costs[i-1][1],costs[i-1][2])
            costs[i][1] += min(costs[i-1][0],costs[i-1][2])
            costs[i][2] += min(costs[i-1][0],costs[i-1][1])        
           
        return min(costs[len(costs)-1][0],costs[len(costs)-1][1],costs[len(costs)-1][2])
    
    
# 2. space = O(nm); n = number of house, m = number of colors = 3(here)
class Paint:
    def minCost(costs):
        if len(costs) == 0:
            return 0
        dp = costs
        for i in range(1,len(dp[0]):
            dp[i][0] += min(dp[i-1][1],dp[i-1][2])
            dp[i][1] += min(dp[i-1][0],dp[i-1],[2])
            dp[i][2] += min(dp[i-1][0],dp[i-1],[1])
                       
                       
        return min(dp[-1][0],dp[-1][1],dp[-1][2])