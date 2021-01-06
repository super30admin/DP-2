# Time Complexity : O(m*n) where m and n are dimensions of costs matrix
# Space Complexity : O(m*n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No, since the explanation from class was clear.


# Your code here along with comments explaining your approach
# Dynamic Programming approach from class, where we use dp matrix to take solution
# from the sub problems and use to solve bigger problems

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if len(costs) == 0: return 0
        rows = len(costs)
        dp = [[0 for x in [0,1,2]] for y in range(rows)]
        dp[0][0] = costs[0][0]
        dp[0][1] = costs[0][1]
        dp[0][2] = costs[0][2]
        
        for i in range(1, rows):
            for j in [0, 1, 2]:
                if j == 0:
                    dp[i][j] = min(dp[i-1][2]+costs[i][j], dp[i-1][1]+costs[i][j])
                elif j == 1:
                    dp[i][j] = min(dp[i-1][0]+costs[i][j], dp[i-1][2]+costs[i][j])
                else:
                    dp[i][j] = min(dp[i-1][0]+costs[i][j], dp[i-1][1]+costs[i][j])
        
        return min(dp[rows-1][0],dp[rows-1][1],dp[rows-1][2])