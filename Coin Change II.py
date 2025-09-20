#  Time Complexity : O(m * n)
#  Space Complexity : O(m * n)
#  Did this code successfully run on Leetcode : Yes
#  Three line explanation of solution in plain english : This code solves the coin change II problem (counting the number of ways to make up an amount using given coins) with dynamic programming. It uses a 1D dp array where dp[j] stores the number of ways to form amount j; it starts with dp[0] = 1 (base case: one way to make 0). For each coin, it updates the dp array by adding the number of ways to form the remaining amount (j - coin) to dp[j], and finally returns dp[n] as the total ways to form the target amount.

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        m = len(coins)
        n = amount

        dp = [0] * (n + 1)
        dp[0] = 1

        for i in range(1, m + 1):
            for j in range(n + 1):
                if j >= coins[i - 1]:
                    dp[j] = dp[j] + dp[j - coins[i - 1]]
        
        return dp[n]