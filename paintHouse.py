"""
256. Paint house
TC - O(n)
SC - O(n)
"""

c = [[17, 2, 17], [16, 16, 5], [14, 3, 19]]


def paintHouse(costs):
    row = len(costs)
    # 3 colors
    col = 3

    # create matrix
    dp = [[0 for j in range(col)] for i in range(row)]

    # copy last row in dp
    for j in range(0, col):
        dp[row - 1][j] = costs[row - 1][j]

    # add to second last row
    for i in range(row-2, -1, -1):
        dp[i][0] = costs[i][0] + min(dp[i + 1][1], dp[i + 1][2])
        dp[i][1] = costs[i][1] + min(dp[i + 1][0], dp[i + 1][2])
        dp[i][2] = costs[i][2] + min(dp[i + 1][0], dp[i + 1][1])

    min_val = float('inf')

    for j in range(0, col):
        # select min value
        min_val = min(min_val, dp[0][j])
    return min_val


print(paintHouse(c))
