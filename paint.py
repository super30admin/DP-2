# linear time and space complexity
def minCost(costs):
    if not costs:
        return 0

    n = len(costs)
    
    # Initialize a 2D DP array to store the minimum cost at each house for each color.
    dp = [[0] * 3 for _ in range(n)]
    
    # Initialize the DP array with the costs for the first house.
    dp[0] = costs[0]
    
    # Iterate through the remaining houses, updating the DP array.
    for i in range(1, n):
        dp[i][0] = costs[i][0] + min(dp[i-1][1], dp[i-1][2])
        dp[i][1] = costs[i][1] + min(dp[i-1][0], dp[i-1][2])
        dp[i][2] = costs[i][2] + min(dp[i-1][0], dp[i-1][1])
    
 
    return min(dp[-1])


costs = [[17,2,17],[16,16,5],[14,3,19]]
minimum_cost = minCost(costs)
print("Minimum cost to paint all houses:", minimum_cost)
