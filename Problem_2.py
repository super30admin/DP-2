"""
Time Complexity - O(n), where n = number of houses
Space Complexity - O(n), for the dp table of size n x 3

Approach -
- Each house can be painted with Red (0), Blue (1), or Green (2).
- Constraint: No two adjacent houses can be painted with the same color.
- I create a DP table where:
    - dp[i][0] = min total cost to paint house i red
    - dp[i][1] = min total cost to paint house i blue
    - dp[i][2] = min total cost to paint house i green
- Base case: dp[0] = costs[0] → initial painting costs for the first house
- For each house from i=1 to n:
    - I choose the current color and add the minimum cost from the two previous different colors.
    - This ensures no two adjacent houses have the same color.
- Finally, I return the minimum value among the last house's three color choices.
"""

def minCost(costs):
    n = len(costs)
    dp = [[0,0,0] for _ in range(len(costs))]
    dp[0] = costs[0]
    for i in range(1, n):
        dp[i][0] = costs[i][0] + min(dp[i-1][1], dp[i-1][2])
        dp[i][1] = costs[i][1] + min(dp[i-1][0], dp[i-1][2])
        dp[i][2] = costs[i][2] + min(dp[i-1][0], dp[i-1][1])
    return min(dp[n-1])
costs = [[17,2,17],[16,16,5],[14,3,19]]
print(minCost(costs))
print(minCost([[7,6,2]]))