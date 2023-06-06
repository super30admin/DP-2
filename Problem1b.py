class Solution(object):
    def minCost(self, costs):
        """
        Calculates the minimum cost of painting the houses using dynamic programming.
        Time complexity: O(n),  n --> number of houses
        Space complexity: O(n),  
        :type costs: List[List[int]]
        :rtype: int
        """
        # Base cases: if there are no houses, return 0
        if len(costs) == 0:
            return 0

        # If there is only one house, return the minimum cost of painting it with a single color
        if len(costs) == 1:
            return min(costs[0][0], min(costs[0][1], costs[0][2]))

        # Initialize the dynamic programming table (dp)
        dp = [[0 for _ in range(len(costs[0]))] for _ in range(len(costs))]

        # Set the last row of the dp table with the costs of painting the last house with each color
        dp[len(costs) - 1][0] = costs[len(costs) - 1][0]
        dp[len(costs) - 1][1] = costs[len(costs) - 1][1]
        dp[len(costs) - 1][2] = costs[len(costs) - 1][2]

        # Iterate from the second last row up to the first row
        for i in range(len(costs) - 2, -1, -1):
            # Calculate the minimum cost of painting the current house with each color
            dp[i][0] = costs[i][0] + min(dp[i + 1][1], dp[i + 1][2])
            dp[i][1] = costs[i][1] + min(dp[i + 1][0], dp[i + 1][2])
            dp[i][2] = costs[i][2] + min(dp[i + 1][0], dp[i + 1][1])

        # Return the minimum cost of painting the first house with each color
        return min(dp[0][0], min(dp[0][1], dp[0][2]))
