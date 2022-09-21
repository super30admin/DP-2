# Time Complexity : O(n)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

def minCost(costs):
    if costs == None or len(costs) == 0:
        return 0

    n = len(costs)
    dp = [[0 for i in range(3)] for j in range(n)]

    for j in range(3):
        dp[n-1][j] = costs[n-1][j]

    for i in range(n-2, -1, -1):
        dp[i][0] = costs[i][0] + min(dp[i+1][1], dp[i+1][2])
        dp[i][1] = costs[i][1] + min(dp[i+1][0], dp[i+1][2])
        dp[i][2] = costs[i][2] + min(dp[i+1][0], dp[i+1][1])

    return min(dp[0])

costs = [[17, 2, 17], [16, 16, 5], [14, 3, 19]]
print(minCost(costs))