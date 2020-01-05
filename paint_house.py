// Time Complexity :o(mn)
// Space Complexity :o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if(costs==None or len(costs)==0):
            return 0
        rows=len(costs)
        dp=[[None for i in range(3)]for j in range(rows)]
        dp[0][0]=costs[0][0]
        dp[0][1]=costs[0][1]
        dp[0][2]=costs[0][2]
        for i in range(1,rows):
            dp[i][0]=costs[i][0] + min(dp[i-1][1],dp[i-1][2])
            dp[i][1]=costs[i][1] + min(dp[i-1][0],dp[i-1][2])
            dp[i][2]=costs[i][2] + min(dp[i-1][0],dp[i-1][1])
        return min(dp[rows-1][0], dp[rows-1][1], dp[rows-1][2])
        
        
// For Space - o(1)
class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if(costs==None or len(costs)==0):
            return 0
        rows=len(costs)
        costs[0][0]=costs[0][0]
        costs[0][1]=costs[0][1]
        costs[0][2]=costs[0][2]
        for i in range(1,rows):
            costs[i][0]=costs[i][0] + min(costs[i-1][1],costs[i-1][2])
            costs[i][1]=costs[i][1] + min(costs[i-1][0],costs[i-1][2])
            costs[i][2]=costs[i][2] + min(costs[i-1][0],costs[i-1][1])
        return min(costs[rows-1][0], costs[rows-1][1], costs[rows-1][2])
