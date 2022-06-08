'''
Time Complexity : O(m*n) where m is number of denominations and n is required amount
Space Complexity: O(n) where n is required amount (Using 1D DP)
Run on LeetCode : YES
Problems: Optimizing 2D DP to 1D DP
'''
class Solution:
    def change(self, amount: int, coins: list[int]) -> int:
        length = amount + 1
        dp = [0] * length
        dp[0] = 1
        for i in range(len(coins)):
            for j in range(length):
                 if not j < coins[i]:
                        dp[j] += dp[j - coins[i]]
        return dp[amount]