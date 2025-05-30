
#Time Complexity: O(N)
#Space Complexity: O(N)
#-----------------------------TABULATION-------------------------
def minCost_tabulation(costs):
    if not costs:
        return 0
    
    n = len(costs)
    dp = [[0]*3 for _ in range(n)]
    
    # Base case: fill in the cost of the last house
    dp[n-1][0] = costs[n-1][0]
    dp[n-1][1] = costs[n-1][1]
    dp[n-1][2] = costs[n-1][2]
    
    # Bottom-up
    for i in range(n-2, -1, -1):
        dp[i][0] = costs[i][0] + min(dp[i+1][1], dp[i+1][2])
        dp[i][1] = costs[i][1] + min(dp[i+1][0], dp[i+1][2])
        dp[i][2] = costs[i][2] + min(dp[i+1][0], dp[i+1][1])
    
    return min(dp[0][0], dp[0][1], dp[0][2])

#---------------------SPACE OPTIMIZED--------------------------------
#Time Complexity: O(N)
#Space Complexity: O(1)

def minCost_optimized(costs):
    if not costs:
        return 0
    
    n = len(costs)
    prev = costs[-1][:]  # Copy the last house cost

    for i in range(n-2, -1, -1):
        curr = [0]*3
        curr[0] = costs[i][0] + min(prev[1], prev[2])
        curr[1] = costs[i][1] + min(prev[0], prev[2])
        curr[2] = costs[i][2] + min(prev[0], prev[1])
        prev = curr  # Move window
    
    return min(prev)
