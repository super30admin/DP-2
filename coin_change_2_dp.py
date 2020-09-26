"""
Problem: Compute the number of combinations of coins that make up the amount.
Leetcode: https://leetcode.com/problems/coin-change-2/
Example:
    Input: amount = 5, coins = [1, 2, 5]
    Output: 4
Solution: Dynamic programming
Time Complexity: O(n * k), where n is the length of coin array and k is the amount
Space Complexity: O(k), to keep dp array, k is the amount.
"""


class Solution:
    def change(self, amount, coins):
        # Define an array to combination at each amount
        dp = [0] * (amount + 1)
        # base case - no coins
        dp[0] = 1

        for coin in coins:
            # For each amount x, compute the number of combinations of coins
            for x in range(coin, amount + 1):
                dp[x] += dp[x - coin]
        return dp[amount]


obj = Solution()
print(obj.change(5, [1,2,5]))