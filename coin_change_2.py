#Tume complexity: O(n*T): where n: # of coins, T: target amount value
#Space complexity: O(n*T)
#This algorithm uses dynamic programming, by converting it into several subproblems, where each subproblem solves for
# finding the number of ways to reach a target values, by first picking certain number of coins.
# We keep on adding more number of coins, till we cover all coins, and target value is reached.

import numpy as np

def solution(amount: int, coins) -> int:

    if len(coins) == 0 and amount == 0:
        return 1

    dp = np.zeros((len(coins) + 1, amount + 1))

    dp[:, 0] = 1
    dp[0, 1:] = 0
    print(dp)

    for row in range(1, len(coins) + 1):
        for col in range(1, amount + 1):
            if col < coins[row - 1]:
                dp[row][col] = dp[row - 1][col]

            else:
                dp[row][col] = dp[row - 1][col] + dp[row][col - coins[row - 1]]  # choosing and not choosing

    return int(dp[len(coins)][amount])


print(solution(5, [1, 2, 5]))
