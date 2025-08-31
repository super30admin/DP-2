"""
Time Complexity: O(m * n)
    - Each coin iterates over all amounts up to n.
Space Complexity: O(n)
    - We use a 1D dp array of size n+1.
"""


class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        n = amount
        m = len(coins)
        
        dp = [0 for _ in range(n+1)]
        dp[0] = 1
        for i in range(1, m+1):
            for j in range(n+1):
                if j >= coins[i-1]:
                    dp[j] = dp[j] + dp[j-coins[i-1]]
        return dp[-1]

