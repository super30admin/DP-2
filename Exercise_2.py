# Time Complexity : O(amount * n), where n is the number of coins.
# Space Complexity : O(amount)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : I had to loop over coins first so the same combination is not counted in different orders.
# Approach: I used dp[i] to store how many combinations can make amount i.
# For each coin, I updated all amounts that can include that coin.
# Since coins are processed one at a time, each combination is counted once.


class Solution:

    def change(self, amount, coins):
        dp = [0] * (amount + 1)
        dp[0] = 1

        for coin in coins:
            for current_amount in range(coin, amount + 1):
                dp[current_amount] += dp[current_amount - coin]

        return dp[amount]
