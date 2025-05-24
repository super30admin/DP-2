#  Memoization
# Time Complexity: O(n*amount)
# Space Complexity: O(n*amount)
def change(amount, coins):
    memo = {}

    def helper(i, amount):
        if (i, amount) in memo:
            return memo[(i, amount)]

        if i == 0:
            return 1 if amount % coins[i] == 0 else 0

        take = 0
        if amount >= coins[i]:
            take = helper(i, amount - coins[i])
        not_take = helper(i - 1, amount)
        memo[(i, amount)] = take + not_take
        return memo[(i, amount)]

    return helper(len(coins) - 1, amount)


# DP
# Time Complexity: O(n*amount)
# Space Complexity: O(n*amount)
def change(amount, coins):
    n = len(coins)
    dp = [[0]*(amount+1) for _ in range(n)]

    for i in range(n):
        dp[i][0] = 1

    for i in range(n):
        for j in range(1, amount+1):
            if i == 0:
                dp[i][j] = 1 if j % coins[i] == 0 else 0
            else:
                not_take = dp[i-1][j]
                take = dp[i][j-coins[i]] if j >= coins[i] else 0
                dp[i][j] = take + not_take

    return dp[n-1][amount]

# DP 
# Time Complexity: O(n*amount)
# Space Complexity: O(1)

def change(amount, coins):
    dp = [0]*(amount+1)
    dp[0] = 1

    for coin in coins:
        for i in range(coin, amount+1):
            dp[i] += dp[i-coin]

    return dp[amount]




