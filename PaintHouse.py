# Time complexity : O(m*n)
# Space complexity : O(m*n)

# The code ran on Leetcode

# Copy the costs array. Dont change the values in first row since they correspond to the minimum cost required to paint a house with a particular color.
# From index 1, calculate the minimum cost to calculate house with a particular color by costs[i][j] += min(costs[i-1][(j+1)%3], costs[i-1][(j+2)%3])



class Solution:
    """
    @param costs: n x 3 cost matrix
    @return: An integer, the minimum cost to paint all houses
    """
    def min_cost(self, costs) -> int:

        dp = costs

        for i in range(1, len(dp)):
            for j in range(3):
                dp[i][j] += min(dp[i-1][(j+1)%3], dp[i-1][(j+2)%3])

        return min(dp[-1])