"""
Problem : 2

Recursive
Time Complexity : O(2^m))
Space Complexity : O(2^m)

DP
Time Complexity : O(n)
Space Complexity : O(n)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

In recursive solution - choosing or not choosing the house with any color and then in the next choosing any house but without previous choosen color
In dp approach - creating a dp matrix and implementing the recursive tree in the form of table
"""

#  Paint House

# Approach - 1

class Solution(object):
    def minCost(self, costs):
        if costs==None:
            return 0
        red=self.helper(costs,0,0,0)
        blue=self.helper(costs,0,1,0)
        green=self.helper(costs,0,2,0)
        
        return min(red,min(blue,green))
    
    def helper(self,costs,i,color,amount):
        # base
        if i>=len(costs):
            return amount
        # logic
        if color==0:
            return min(self.helper(costs,i+1,1,amount+costs[i][0]),self.helper(costs,i+1,2,amount+costs[i][0]))
        elif color==1:
            return min(self.helper(costs,i+1,0,amount+costs[i][1]),self.helper(costs,i+1,2,amount+costs[i][1]))
        elif color==2:
            return min(self.helper(costs,i+1,0,amount+costs[i][2]),self.helper(costs,i+1,1,amount+costs[i][2]))
        

# Approach - 2

class Solution(object):
    def minCost(self, costs):
        
        if len(costs)==0:
            return 0
        if len(costs)==1:
            return min(costs[0][0],min(costs[0][1],costs[0][2]))
        dp=[[0]*len(costs[0]) for _ in range(len(costs))]
        dp = [[0 for _ in range(len(costs[0]))] for _ in range(len(costs))]
        

        dp[len(costs)-1][0]=costs[len(costs)-1][0]
        dp[len(costs)-1][1]=costs[len(costs)-1][1]
        dp[len(costs)-1][2]=costs[len(costs)-1][2]
        # print(dp)
        

        for i in range(len(costs)-2,-1,-1):
            dp[i][0]=costs[i][0]+min(dp[i+1][1],dp[i+1][2])
            dp[i][1]=costs[i][1]+min(dp[i+1][0],dp[i+1][2])
            dp[i][2]=costs[i][2]+min(dp[i+1][0],dp[i+1][1])
        
        return min(dp[0][0],min(dp[0][1],dp[0][2]))