# did not execute in leetcode
# time - O(N), space O(N)
# created a dp matrix on size same as the costs matrix and then at everystep getting the minimum of other two colors.
def minCost(costs):
    dp = [[0 for i in range(len(costs[0]))] for j in range(len(costs))]
    if costs is None or len(costs) == 0: return 0
    dp[0][0] = costs[0][0] # red
    dp[0][1] = costs[0][1] # green
    dp[0][2] = costs[0][2] # blue

    for i in range(len(dp)):
        dp[i][0] = min(dp[i-1][1], dp[i-1][2]) + costs[i][0]  # red
        dp[i][1] = min(dp[i - 1][0], dp[i - 1][2]) + costs[i][1]  # green
        dp[i][2] = min(dp[i - 1][1], dp[i - 1][0]) + costs[i][2]  # blue
    print(dp)
    # return the minimum from last row.
    return min(dp[i][0],dp[i][1],dp[i][2])



print(minCost([]))