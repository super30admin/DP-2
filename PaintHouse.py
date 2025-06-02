# Implementation =: Use dynamic programming by updating each house’s cost in place based on the previous house’s minimal costs for the other two colors.
# Time Complexity: O(n), where n = number of houses, since we process each house once.
# Space Complexity: O(1), since we reuse the input array for DP and only use a constant amount of extra space.

from typing import List

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        """
        Returns the minimum cost to paint all houses such that no two adjacent houses have the same color.
        costs[i][j] is the cost to paint house i with color j (0:red, 1:blue, 2:green).
        """
        if not costs:
            return 0
        
        n = len(costs)
        # Start from the second house and update using the previous house’s costs
        for i in range(1, n):
            # If we paint house i red (0), we must add min cost of painting house i-1 blue or green
            costs[i][0] += min(costs[i - 1][1], costs[i - 1][2])
            # If we paint house i blue (1), add min cost of painting i-1 red or green
            costs[i][1] += min(costs[i - 1][0], costs[i - 1][2])
            # If we paint house i green (2), add min cost of painting i-1 red or blue
            costs[i][2] += min(costs[i - 1][0], costs[i - 1][1])
        
        # After updating, the answer is the min cost to paint the last house with any color
        return min(costs[n - 1])
