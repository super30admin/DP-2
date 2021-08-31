# // Time Complexity : O(n) where n: number of houses
# // Space Complexity : O(n) 
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : how to design the table. (cols and the cell values)

# // Your code here along with comments explaining your approach
class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if not costs: return 0
        dp = [[0 for _ in range(len(costs[0]))] for _ in range(len(costs))]
        for j in range(len(dp[0])):
            dp[-1][j] = costs[-1][j]
        
        for i in range(len(costs)-2,-1,-1):
            # for j in range(len(costs[0])):
            dp[i][0] = costs[i][0] + min(dp[i+1][1],dp[i+1][2])
            dp[i][1] = costs[i][1] + min(dp[i+1][0],dp[i+1][2])
            dp[i][2] = costs[i][2] + min(dp[i+1][0],dp[i+1][1])
        
        return min(dp[0][:])