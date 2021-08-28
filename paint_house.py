# Did this code successfully run on Leetcode : YES

# TC: O(N)
# SC: O(N)

# approach
# explore all possible options
# at first step we have 3 choices and post that every house will have 2 choices of colors
# assume first was R, then second can be B/G -> if second is B, third is R/G and so on
# hard coding column indices (color index value) because it will always be either R/B/G -> 3 choices only


class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        n = len(costs)
        dp = [[0 for _ in range(3)] for _ in range(n)]
        dp[0] = costs[0]
        for i in range(1, n):
            dp[i][0] = costs[i][0] + min(dp[i-1][1], dp[i-1][2])
            dp[i][1] = costs[i][1] + min(dp[i-1][0], dp[i-1][2])
            dp[i][2] = costs[i][2] + min(dp[i-1][0], dp[i-1][1])
        return min(dp[-1])