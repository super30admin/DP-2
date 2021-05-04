""" Time Complexity : O(mn)
 Space Complexity : O(mn)
 Did this code successfully run on Leetcode :Yes
 Any problem you faced while coding this : No 
"""

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        
        if not costs:
            return 0
        
        dp = [[0]*len(costs[0]) for i in range(len(costs))]
        
        for i in range(len(costs)-1,-1,-1):
            for j in range(len(costs[0])):
                if i == len(costs) -1:
                    dp[i][j] = costs[i][j]
                else:
                    if j == 0:
                        dp[i][j] = costs[i][j] + min(dp[i+1][1],dp[i+1][2])
                    elif j == 1:
                        dp[i][j] = costs[i][j] + min(dp[i+1][0],dp[i+1][2])
                    else:
                        dp[i][j] = costs[i][j] + min(dp[i+1][0],dp[i+1][1])
        print(dp)
        
        return min(dp[0])
       