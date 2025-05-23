"""
1D DP array dp[amount + 1] - dp[i] is no of ways to make amount i.
dp[0] = 1 base case: one way to make amount 0
For each coin, iterate from that coin value to amount, updating dp[i] += dp[i - coin]
"""
"""
Time Complexity: O(amount * len(coins)) 
Space Complexity: O(amount) – for the DP array
"""

class coinChangeTwo:
    def change(self, amount: int, coins: list[int]) -> int:
        dp = [0] * (amount + 1)
        dp[0] = 1

        for coin in coins:
            for i in range(coin, amount + 1):
                dp[i] += dp[i - coin]

        return dp[amount]

if __name__=="__main__":
    obj = coinChangeTwo()
    amount = 5
    coins = [1,2,5]
    print(obj.change(amount,coins))
