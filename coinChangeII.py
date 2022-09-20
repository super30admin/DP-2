"""
518. Coin change II
TC - O(nm)
SC - O(m)
"""

a = 5
c = [1, 2, 5]


def coinChangeII(amount, coins):
    if coins is None or len(coins) == 0:
        return -1

    dp = [0]*(amount + 1)

    dp[0] = 1

    for i in coins:
        for j in range(i, amount+1):
            dp[j] += dp[j - i]
    return dp[amount]


print(coinChangeII(a, c))
