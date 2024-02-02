'''
Time Complexity - O(n). The number of houses in to be painted
Space Complexity - O(n). Again the number of houses to be painted

This requires leetcode premium.
'''

class Solution:
    def min_cost(self, costs: List[List[int]]) -> int:
        # write your code here
        n = len(costs)
        dp = [[0 for j in range(3)]for i in range(n)] #initialize the DP array
        dp[n-1][0] = costs[n-1][0] #We set the initial values of dp to that of the bottom row of costs
        dp[n-1][1] = costs[n-1][1]
        dp[n-1][2] = costs[n-1][2]
        for i in range(n-2,-1,0):
            dp[i][0] = costs[i][0] + min(dp[i+1][1],dp[i+1][2]) #If we paint one house with red, the next house can be painted either green[1] or blue[2]
            dp[i][1] = costs[i][1] + min(dp[i+1][0],dp[i+1][2]) #If we paint one house with green, the next house can be painted either red[0] or blue[2]
            dp[i][2] = costs[i][2] + min(dp[i+1][0],dp[i+1][1]) #If we paint one house with blue, the next house can be painted either red[0] or green[1]
        return min(dp[0][0],min(dp[0][1],dp[0][2])) #return the min of the first row.