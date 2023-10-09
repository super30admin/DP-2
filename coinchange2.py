# linear time and space complexity
def coinChangeWays(coins, amount):
    # Initialize a list to store the number of ways to make change for each amount from 0 to 'amount'.
    # Initialize all values to 0 except for 0, which has 1 way (no coins).
    dp = [0] * (amount + 1)
    dp[0] = 1

    # Iterate through each coin denomination.
    for coin in coins:
        # For each coin, update the 'dp' list to reflect the number of ways to make change.
        for i in range(coin, amount + 1):
            dp[i] += dp[i - coin]

   
    return dp[amount]


coins = [1, 2, 5]
amount = 5
ways = coinChangeWays(coins, amount)
print("Number of ways to make change for", amount, "is", ways)
