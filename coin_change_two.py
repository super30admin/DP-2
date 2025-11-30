class Solution:
    """
    Time Complexity: O(m * n) 
        m = number of coins, n = amount
        We fill an m x n DP table.

    Space Complexity: O(m * n)
        Using a 2D DP array dp[m+1][n+1].

    Approaches:
    1. Recursion + Memoization:
       Try using or skipping each coin and recursively compute ways 
       to reach the remaining amount. Cache results to avoid recomputation.

    2. Bottom-up DP (2D Tabulation):
       Create a DP table where dp[i][j] represents the number of ways 
       to make amount j using the first i coins.
       For each coin, we decide:
         - Not using the coin (dp[i-1][j])
         - Using the coin (dp[i][j - coin value])

    3. Bottom-up DP (Optimized to 1D array):
       Iterate coins first, then amount—which ensures combinations 
       (no permutation counting) and reduces space to O(n).
    """
    def change(self, amount: int, coins: List[int]) -> int:
        m = len(coins)
        n = amount

        # dp[i][j] = number of ways to form amount j using first i coins
        dp = [[0] * (n + 1) for _ in range(m + 1)]

        # Base case: One way to form amount 0 (choose nothing)
        dp[0][0] = 1

        for i in range(1, m + 1):
            for j in range(n + 1):
                # If current amount is less than the coin value,
                # we cannot use this coin
                if j < coins[i - 1]:
                    dp[i][j] = dp[i - 1][j]
                else:
                    # Two choices:
                    # 1. Don't use the coin -> dp[i - 1][j]
                    # 2. Use the coin -> dp[i][j - coin_value]
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]]

        return dp[m][n]
