class Solution:
    """
    Time Complexity: O(n) -> We process each house once.
    Space Complexity: O(1) -> We only store costs for 3 colors per step.

    Approaches:
    1. Top-down DP (Recursion + Memoization):
       Recursively explore all ways to paint each house while ensuring no two adjacent
       houses share the same color. Cache results of subproblems to avoid recomputation.

    2. Bottom-up DP (Tabulation with DP Table):
       Build a dp[n][3] table where each row stores the minimum cost to paint up to
       that house with each color. Each entry depends on the minimum of the other two
       colors from the previous house.

    3. Bottom-up DP with Space Optimization (Tabulation -> O(1) Space):
       Instead of a full dp table, keep only the previous house's three minimum costs.
       Update these values iteratively to compute the final minimum cost.
    """
    def minCost(self, costs: List[List[int]]) -> int:
        n = len(costs)
        
        # If there are no houses, total cost is 0
        if n == 0:
            return 0
        
        # Initialize minimum costs for painting the first house
        chooseRedPrev = costs[0][0]
        chooseBluePrev = costs[0][1]
        chooseGreenPrev = costs[0][2]

        # Iterate through each subsequent house
        for i in range(1, n):
            # Compute the new costs if we paint this house each color
            chooseRed = costs[i][0] + min(chooseBluePrev, chooseGreenPrev)
            chooseBlue = costs[i][1] + min(chooseRedPrev, chooseGreenPrev)
            chooseGreen = costs[i][2] + min(chooseRedPrev, chooseBluePrev)
            
            # Update previous values for the next iteration
            chooseRedPrev, chooseBluePrev, chooseGreenPrev = (
                chooseRed, chooseBlue, chooseGreen
            )

        # The answer is the minimum of the last computed color choices
        return min(chooseRedPrev, chooseBluePrev, chooseGreenPrev)
