def minCost(dp):
    if len(dp) == 0 or dp is None:
        return 0

    # dp = [len(costs)] * 3
    # print(dp)
    # for j in range(len(costs)):
    #     dp[len(dp)][j] = costs[len(costs) - 1][j]

    print(dp)

    for i in range(len(dp[-1])):
        dp[i][0] = dp[i][0] + min(dp[i][1], dp[i][2])
        dp[i][1] = dp[i][1] + min(dp[i][0], dp[i][2])
        dp[i][2] = dp[i][2] + min(dp[i][0], dp[i][1])

    return min(dp[i][0], min(dp[i][1], dp[i][2]))

cost = [[17,2,17],[16,16,5],[14,3,19]]
print(minCost(cost))
