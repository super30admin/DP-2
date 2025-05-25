# time complexity : O(n)
# Space complexity : O(n)
def cost_of_painting(costs)->int:
    n = len(costs)
    dp = [[0 for _ in range(3)] for _ in range(3)]
    dp[n-1][0] = costs[n-1][0]
    dp[n-1][1] = costs[n-1][1]
    dp[n-1][2] = costs[n-1][2]

    for i in range(n-2, -1, -1):
        dp[i][0] = costs[i][0] + min(dp[i+1][1], dp[i+1][2])
        dp[i][1] = costs[i][1] + min(dp[i+1][0], dp[i+1][2])
        dp[i][2] = costs[i][2] + min(dp[i+1][0], dp[i+1][1])

    return min(dp[0][0], dp[0][1], dp[0][2])

if __name__ == "__main__":
    costs = [[17,2,17], [16,16,5], [14,3,19]]
    print(cost_of_painting(costs))