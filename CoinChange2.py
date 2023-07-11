# Time complexity: O(n(coins)*m(amount)) 
# Space Complexity: O(n(coins)*m(amount))
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        m = [[0] * (amount + 1) for _ in range(len(coins) + 1)]
        m[0][0] = 1

        for i in range(1, len(coins) + 1):
            for j in range(0, amount + 1):
                if coins[i - 1] > j:
                    m[i][j] = m[i - 1][j]
                else:
                    m[i][j] = m[i - 1][j] + m[i][j - coins[i - 1]]

        return m[-1][-1]