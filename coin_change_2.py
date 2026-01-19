# 518. Coin Change 2
# Bottom-Up Dynamic Programming
# Time Complexity: O(m*n), Space Complexity: O(n)

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        m = len(coins)
        n = amount
        # Initialize dp array where dp[j] will be storing the number of combinations for amount j
        dp = [0 for _ in range(n + 1)]
        dp[0] = 1
        for i in range(1,m+1):
            # For current coin, update all amounts >= coin. We go left-to-right so each coin can be used multiple times,
            # but different orders of the same combination are not double-counted.
            for j in range(n+1):
                if coins[i-1]>j:
                    # Current coin cannot contribute to amount j
                    dp[j] = dp[j]
                else:
                    # Include current coin and add ways to make amount j - coins[i-1]
                    dp[j] = dp[j] + dp[j-coins[i-1]]
        return dp[n]


        