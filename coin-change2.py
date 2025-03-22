'''

This solution uses a 1D Dynamic Programming (DP) array where dp[j] represents the number of ways to form the amount j using the given coins. 
It initializes dp[0] = 1 since there is only one way to make the amount 0 (by taking no coins). 
For each coin, it iterates through possible amounts from coin to amount, 
updating dp[j] by adding the count of ways to make j - coin, ensuring that each amount is built using available coins in a bottom-up manner

Time Complexity: O(n * m)
Space Complexity: O(m)
'''

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        dp = [0] * (amount + 1)
        dp[0] = 1

        for coin in coins:
            for j in range(coin, amount + 1):
                dp[j] += dp[j - coin]

        return dp[amount]