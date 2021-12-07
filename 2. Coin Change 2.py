class Solution:
    # Time Complexity - O(amount * coins)
    # Space Complexity - O(amount * coins)
    def change(self, amount: int, coins) -> int:
        m = len(coins)
        n = amount
        t = [[1] + [0] * amount for _ in range(len(coins) + 1)]

        for i in range(1, m + 1):
            for j in range(1, n + 1):
                if coins[i - 1] <= j:
                    t[i][j] = t[i - 1][j] + t[i][j - coins[i - 1]]
                else:
                    t[i][j] = t[i - 1][j]

        return t[m][n]