#Tume complexity: O(n*T): where n: # of coins, T: target
#Space complexity: O(n*T): where n: # of coins, T: target
#Worked on leetcode
#This algorithm uses dynamic programming, by first calculating the optimal value when
# a coin is not chosen, versus when a coin is chosen, for each coin iteratively.
# It then takes the maximum value of when all coins are present, and we decide whether
# or not to choose it.

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
