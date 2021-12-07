class Solution:
    # Time Complexity = O(rows*columns)
    # Space Complexity = O(1) as we're using the same array to update the values

    def minCost(self, costs) -> int:
        # Creating the matrix with values just above the constraints.
        dp = [[21, 21, 21] for i in range(len(costs))]
        dp[0] = costs[0]

        # Going from top to bottom. Updating the costs by picking the minimum from the above rows
        for i in range(1, len(costs)):
            dp[i][0] = costs[i][0] + min(dp[i - 1][1], dp[i - 1][2])
            dp[i][1] = costs[i][1] + min(dp[i - 1][0], dp[i - 1][2])
            dp[i][2] = costs[i][2] + min(dp[i - 1][0], dp[i - 1][1])

        # Return the minimum of the last row of the matrix
        return min(dp[-1])