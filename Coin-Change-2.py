# Time Complexity: O(amount * numberOfCoins)
# Space Complexity: O(amount) #  O(amount * numberOfCoins) for 2D

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        dp = [[0 for _ in range(amount+1)] for _ in range(len(coins)+1)]
        dp[0][0] = 1
        for i in range(1, amount+1):
            dp[0][i] = 0
        for i in range(1, len(coins)+1):
            dp[i][0] = 1
        for i in range(1, len(dp)):
            for j in range(1, len(dp[0])):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]
        return dp[-1][-1]