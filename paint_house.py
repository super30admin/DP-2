#Tume complexity: O(n): where n: # of houses
#Space complexity: O(n)
#This algorithm uses dynamic programming, by converting it into several subproblems, where each subproblem solves for
# finding the optimal cost of house painting, when certain houses are present, and the process keeps on expanding for more
# and more houses, until we cover all houses.

def solution(costs):
    num_houses = len(costs)
    num_colors = len(costs[0])
    dp = costs

    for i in range(1, num_houses):
        for j in range(num_colors):
            dp[i][j] = min(dp[i-1][0:j]+dp[i-1][j+1:]) + dp[i][j]

    return min(dp[num_houses-1])


print(solution([[17, 2, 17], [16, 16, 5], [14, 3, 19]]))
