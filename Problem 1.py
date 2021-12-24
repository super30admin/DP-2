# Time: O(n)
# Space: O(1)
def paint_house(cost):
    for i in range(1, len(dp)):
        cost[i][0] = cost[i][0]+min(dp[i-1][1], dp[i-1][2])
        cost[i][1] = cost[i][1]+min(dp[i-1][0], dp[i-1][2])
        cost[i][2] = cost[i][2]+min(dp[i-1][1], dp[i-1][0])
    n = len(cost)
    return min(cost[n-1][1],min(cost[n-1][0], cost[n-1][2]))
