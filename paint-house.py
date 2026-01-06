#-------------Solution 1 : 2D Matrix--------
''' Time Complexity : O(m*n)
    Space Complexity : O(m*n)

    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No
'''    
class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        rows= len(costs)
        cols = len(costs[0])
        dp = [[0 for _ in range(cols)] for _ in range(rows)]
        for i in range(rows):
            for j in range(cols):
                if i == 0 :
                    dp[i][j] = costs[i][j]
                else:
                    if j == 0:
                        dp[i][j] = min(costs[i][j]+dp[i-1][1], costs[i][j]+dp[i-1][2])
                    if j == 1:
                        dp[i][j] = min(costs[i][j]+dp[i-1][0], costs[i][j]+dp[i-1][2])
                    if j == 2:
                        dp[i][j] = min(costs[i][j]+dp[i-1][0], costs[i][j]+dp[i-1][1])
        return min(dp[rows-1][0],dp[rows-1][1],dp[rows-1][2])