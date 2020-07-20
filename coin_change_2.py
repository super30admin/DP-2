#Tume complexity: O(n*T): where n: # of coins, T: target amount value
#Space complexity: O(n*T)
#This algorithm uses dynamic programming, by converting it into several subproblems, where each subproblem solves for
# finding the number of ways to reach a target values, by first picking certain number of coins.
# We keep on adding more number of coins, till we cover all coins, and target value is reached.

def solution(amount, coins):
    dp = [[0 for _ in range(amount+1)] for _ in range(len(coins)+1)]
    dp[0][0] = 1

    for i in range(len(coins)+1):
        dp[i][0] = 1

    for i in range(1, len(coins)+1):
        for j in range(amount+1):
            dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]

    return dp[len(coins)][amount]


print(solution(5, [1, 2, 5]))
