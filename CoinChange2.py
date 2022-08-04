#518. Coin Change 2
"""
Time Complexity : O(n ^ 2)
Space Complexity : O(n ^ 2)
"""
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        dp = [[0 for _ in range(amount + 1)] for __ in range(len(coins) + 1)]
        for i in range(len(coins) + 1):
            dp[i][0] = 1
            
        for i in range(1, len(coins) + 1):
            for j in range(1, amount + 1):
                if coins[i - 1] <= j:
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]]
                else:
                    dp[i][j] = dp[i - 1][j]
        print(dp)
        return dp[len(coins)][amount]
