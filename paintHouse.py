# DP approach
# TC: O(n) iterate over houses row
# Sc: O(n) dp table
from typing import List


class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        # Edge case: If there are no houses, return 0 cost.
        if not costs or len(costs) == 0:
            return 0

        n = len(costs)  # Number of houses

        # DP table with dimensions [n][3]
        dp = [[0] * 3 for _ in range(n)]

        # Initialize the last row with given costs
        for j in range(3):
            dp[n - 1][j] = costs[n - 1][j]

        # Bottom-up calculation from second last row to first row
        for i in range(n - 2, -1, -1):
            dp[i][0] = costs[i][0] + min(dp[i + 1][1], dp[i + 1][2])  # Choosing Red
            dp[i][1] = costs[i][1] + min(dp[i + 1][0], dp[i + 1][2])  # Choosing Green
            dp[i][2] = costs[i][2] + min(dp[i + 1][0], dp[i + 1][1])  # Choosing Blue

        # Return the minimum cost from the first house's choices
        return min(dp[0][0], dp[0][1], dp[0][2])


# Recursive approach
# TC: O(2^n) exponential
# Sc: O(n) recursive stack/tree
# class Solution:
#     def minCost(self, costs: List[List[int]]) -> int:
#         # Edge case: If there are no houses, return 0 cost.
#         if not costs or len(costs) == 0:
#             return 0

#         # Start recursion with each possible color for the first house.
#         red = self.helper(costs, 0, 0, 0)  # Choosing Red
#         green = self.helper(costs, 0, 1, 0)  # Choosing Green
#         blue = self.helper(costs, 0, 2, 0)  # Choosing Blue

#         # Return the minimum cost among all three choices
#         return min(red, green, blue)

#     def helper(self, costs, row, color, cost):
#         # Base Case: If we've reached beyond the last house, return the accumulated cost
#         if row == len(costs):
#             return cost

#         # Recursive Logic:
#         # If current color is Red (0), we can choose Green (1) or Blue (2) next
#         if color == 0:
#             return min(
#                 self.helper(costs, row + 1, 1, cost + costs[row][0]),
#                 self.helper(costs, row + 1, 2, cost + costs[row][0]),
#             )

#         # If current color is Green (1), we can choose Red (0) or Blue (2) next
#         if color == 1:
#             return min(
#                 self.helper(costs, row + 1, 0, cost + costs[row][1]),
#                 self.helper(costs, row + 1, 2, cost + costs[row][1]),
#             )

#         # If current color is Blue (2), we can choose Red (0) or Green (1) next
#         if color == 2:
#             return min(
#                 self.helper(costs, row + 1, 0, cost + costs[row][2]),
#                 self.helper(costs, row + 1, 1, cost + costs[row][2]),
#             )
