# We use dynamic programming to count the number of ways to make up the amount using the given coins.
# We initialize a dp array where dp[i] represents the number of ways to make amount i, starting with dp[0] = 1.
# For each coin, we update the dp array by adding the ways to make up each amount using that coin.

# Time Complexity : O(m * n)
# Space Complexity : O(m)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        dp = [0] * (amount + 1)
        dp[0] = 1
        for coin in coins:
            for i in range(coin, amount + 1):
                dp[i] += dp[i - coin]
        return dp[amount]
        