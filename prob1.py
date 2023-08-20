# Time Complexity : O(n)
# Space Complexity :O(n)
# Passed on Leetcode: yes

def paintHouse(costs):
    m = len(costs)
    n = len(costs[0])

    dp = [[0 for _ in range(n)] for _ in range(m)]

    dp[0][:] = costs[0][:]

    for i in range(1,m):
        # for j in range(n):
        dp[i][0] = costs[i][0] + min(dp[i-1][1], dp[i-1][2])
        dp[i][1] = costs[i][1] + min(dp[i-1][0], dp[i-1][2])
        dp[i][2] = costs[i][2] + min(dp[i-1][1], dp[i-1][0])
    
    return min(dp[m-1])

print(paintHouse([[17,2,17],[16,16,5],[14,3,19]]))

