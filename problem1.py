# Time Complexity : O(n*m) 
# Space Complexity : O(n*m)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : not with the programming logic but i am trying to practice with python as well so with in python was not smooth

'''
Approach
there we are using tabulation methord to solve the problem where
we are building the matrix from bottom up, but before we start with that we need to fill 
the last row manually as that is the basis for building the rest of the matrix

how we build the matrix is we add the cost of current poisiton(house color)
with the min cost of house that was painted 
while doing that we keep in mind not to paint 2 adjesent the same color

'''

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        row = len(costs)
        dp= [[0]*3 for _ in range(row)]
        dp[row-1][0] = costs[row-1][0]
        dp[row-1][1] = costs[row-1][1]
        dp[row-1][2] = costs[row-1][2]
        print(costs[row-1])
        for i in range(row-2,-1,-1):
            
            dp[i][0] = costs[i][0] + min(dp[i+1][1],dp[i+1][2])
            dp[i][1] = costs[i][1] + min(dp[i+1][0],dp[i+1][2])
            dp[i][2] = costs[i][2] + min(dp[i+1][0],dp[i+1][1])
    
        
        result = min(dp[0][0],min(dp[0][1],dp[0][2]))
        return result  
        
        