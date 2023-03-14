# Time Complexity : O(nm) where n: Length of the coins array and m : value of amount
# Space Complexity  : O(m + 1)

from typing import List

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        n = len(coins)
        
        # Initialize dp array with all values as 0
        dp = [0] * (amount + 1)
        dp[0] = 1
        
        # Iterate over coins and update dp array
        for i in range(n):
            for j in range(coins[i], amount+1):
                dp[j] += dp[j-coins[i]]
        
        # Return the final value of dp[amount]
        return dp[amount]