class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if not costs:
            return 0

        num_houses = len(costs)
        num_colors = len(costs[0])

        # Initialize the dp array with the first row of costs
        dp = costs[0]

        # Iterate through the remaining houses
        for i in range(1, num_houses):
            # Create a new dp array for the current row
            new_dp = [0] * num_colors

            # Calculate the minimum cost for each color in the current row
            for j in range(num_colors):
                new_dp[j] = costs[i][j] + min(dp[(j + 1) % num_colors], dp[(j + 2) % num_colors])

            # Update the dp array with the new row
            dp = new_dp

        # Return the minimum cost among the colors in the last row
        return min(dp)
