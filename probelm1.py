#Time Complexity : O(n) ... where n is the number of houses
#Space Complexity : O(n) ... where n is the number of houses
#Any problem you faced while coding this : -

# Used the bottom up tabulation method of dynamic programming programming. Referenced a table where the previously solved sub-problem values were used to iteratively build the soltuion.

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if costs == None or len(costs) == 0:
            return 0
        n = len(costs)
        dp = [[0 for _ in range(3)]for _ in range(n)]
        dp[n-1][0] = costs[n-1][0]
        dp[n-1][1] = costs[n-1][1]
        dp[n-1][2] = costs[n-1][2]

        for i in reversed(range(n-1)):
            dp[i][0] = costs[i][0] + min(dp[i+1][1],dp[i+1][2])
            dp[i][1] = costs[i][1] + min(dp[i+1][0],dp[i+1][2])
            dp[i][2] = costs[i][2] + min(dp[i+1][0],dp[i+1][1])

        return min(dp[0][0], dp[0][1], dp[0][2])