#problem: 518. Coin Change 2
# time: O(mn)
# space: O(mn)
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        m = len(coins)
        n = amount

        # Initialize a 2D array dp
        dp = [[0] * (n + 1) for _ in range(m + 1)]

        # Base case: If the amount is 0, there is one way to make change (no coins)
        for i in range(m + 1):
            dp[i][0] = 1
        for i in range(1, m + 1):
            for j in range(1, n + 1):
                if j < coins[i - 1]:
                    dp[i][j] = dp[i - 1][j]
                else:
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]]

        return dp[m][n]
