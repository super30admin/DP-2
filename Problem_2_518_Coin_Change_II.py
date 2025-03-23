class Solution:
    def change(self, amount: int, coins: List[int]) -> int:

        if amount == 0:
            return 1

        dp = [[0 for i in range(amount + 1)] for j in range(len(coins) + 1)]

        for i in range(len(coins) + 1):
            dp[i][0] = 1

        for i in range(1, len(coins) + 1):
            for j in range(1, amount + 1):
                current_coin_value = coins[i - 1]
                if current_coin_value <= j:
                    # Choice to take or not take the coin
                    dp[i][j] = dp[i - 1][j] + dp[i][j - current_coin_value]
                else:
                    # Cannot take the coin
                    dp[i][j] = dp[i - 1][j]

        return (dp[-1][-1])

