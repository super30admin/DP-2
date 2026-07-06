class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        m = len(coins)
        n = amount

        dp = [0] * (n + 1)
        dp[0] = 1

        for i in range(1, m + 1):
            for j in range(coins[i - 1], n + 1):
                dp[j] += dp[j - coins[i - 1]]

        return dp[n]

    # TC - O(m*n)
    # SC - O(n)