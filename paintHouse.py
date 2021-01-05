// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes


// Your code here along with comments explaining your approach



class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if not costs: return 0
        
        dp = [[0 for _ in range(4)] for _ in range(len(costs) + 1)]
        
        for i in range(1, len(costs) + 1):
            for j in range(1, 4):
                if j == 1:
                    dp[i][j] = min(dp[i-1][j+1] + costs[i-1][j-1], dp[i-1][j+2] + costs[i-1][j-1])
                elif j == 2:
                    dp[i][j] = min(dp[i-1][j-1] + costs[i-1][j-1], dp[i-1][j+1] + costs[i-1][j-1])
                else:
                    dp[i][j] = min(dp[i-1][j-1] + costs[i-1][j-1], dp[i-1][j-2] + costs[i-1][j-1])
        
        return min(dp[len(costs)][1], dp[len(costs)][2], dp[len(costs)][3])