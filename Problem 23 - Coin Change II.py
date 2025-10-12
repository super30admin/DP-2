# 518. Coin Change II

# Time Complexity: O(n*m)
# Space Complexity: O(m)

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        if not coins:
            return 0
        
        n = len(coins)
        dp = [0 for i in range(amount + 1)]

        dp[0] = 1

        for i in range(1, n + 1):
            for j in range(amount + 1):
                if j >= coins[i-1]:
                    dp[j] = dp[j] + dp[j-coins[i-1]]
        
        return dp[amount]