# https://leetcode.com/problems/paint-house

# // Time Complexity : o(n*3) n= number of houses
# // Space Complexity : o(n*3) n= number of houses
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this : None
#
#
# // Your code here along with comments explaining your approach

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        dp = [[0 for i in range(3)] for j in range(len(costs) + 1)]
        for i in range(1, len(costs) + 1):
            for j in range(3):
                # red
                if j == 0:
                    dp[i][j] = costs[i - 1][j] + min(dp[i - 1][1], dp[i - 1][2])

                # blue
                if j == 1:
                    dp[i][j] = costs[i - 1][j] + min(dp[i - 1][0], dp[i - 1][2])

                # green
                if j == 2:
                    dp[i][j] = costs[i - 1][j] + min(dp[i - 1][0], dp[i - 1][1])

        return min(dp[len(costs)][0], dp[len(costs)][1], dp[len(costs)][2])