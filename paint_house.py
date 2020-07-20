#Tume complexity: O(n*T): where n: # of coins, T: target
#Space complexity: O(n*T): where n: # of coins, T: target
#This algorithm uses dynamic programming, by first calculating the optimal value when
# a coin is not chosen, versus when a coin is chosen, for each coin iteratively.
# It then takes the maximum value of when all coins are present, and we decide whether
# or not to choose it.

def solution(costs):
    num_houses = len(costs)
    num_colors = len(costs[0])
    dp = costs

    for i in range(1, num_houses):
        for j in range(num_colors):
            dp[i][j] = min(dp[i-1][0:j]+dp[i-1][j+1:]) + dp[i][j]

    return min(dp[num_houses-1])


print(solution([[17, 2, 17], [16, 16, 5], [14, 3, 19]]))
