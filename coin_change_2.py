"""
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.

Time Complexity: O(n * m), where n is the number of coins and m is the amount of money.
Space Complexity: O(m), where m is the amount of money.
"""


def coin_change_2(coins, amount):
    if not coins or len(coins) == 0:
        return 0

    n, m = len(coins), amount

    dp = [0] * (m + 1)
    dp[0] = 1

    for i in range(1, n+1):
        for j in range(1, m+1):
            if j >= coins[i - 1]:
                dp[j] = dp[j] + dp[j - coins[i - 1]]

    return dp[-1]


coins = [1, 2, 5]
amount = 5
print(coin_change_2(coins, amount))
