# Time Complexity : O(Coins * Amount)
# Space Complexity : O(Coins * Amount)
# Did this code successfully run on Leetcode : yes	


class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        dp = [0] * (amount + 1)
        dp[0] = 1  # Base case: 1 way to make amount 0

        for coin in coins:
            for j in range(coin, amount + 1):
                dp[j] += dp[j - coin]

        return dp[amount]