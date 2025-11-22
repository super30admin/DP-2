# Time Complexity :O(n)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode :No
# Any problem you faced while coding this :No


# Your code here along with comments explaining your approach
#Keep a DP array of size 3 to store the minimum cost to paint the previous house in each color.
# For each house, update each color’s cost by adding its paint cost to the minimum of the other two colors from the previous house.
# After processing all houses, return the minimum value among the three colors, which gives the overall minimum painting cost.

class Solution:
    def minCost(self, costs):
        n = len(costs)
        m = len(costs[0])
        dp = costs[0][:]
        if n ==0:
            return 0
        for i in range(1,n):
            prev_dp = dp[:]
            dp[0] = costs[i][0] + min(prev_dp[1], prev_dp[2])
            dp[1] = costs[i][1] + min(prev_dp[0], prev_dp[2])
            dp[2] = costs[i][2] + min(prev_dp[0], prev_dp[1])
        return min(dp[0],dp[1],dp[2])