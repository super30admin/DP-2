'''
Time Complexity: O(N)
Space Complexity: O(N)

Approach Explation: 
1. Exhaustive Brute Force Approach:
In this approach, we'll try every possible combination of coins and see if it's possible to make the amount.

2. Tabulation Approach:
In this approach, we'll use dynamic programming to build a table that keeps track of the number of ways to make each amount from 0 to the target amount using the given coins.
'''

# Exhaustive Brute Force Approach
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:

        combinations = 0

        def solve(curr, idx):
            if curr == amount:
                nonlocal combinations
                combinations += 1
                return
            if curr > amount:
                return

            for i in range(idx, len(coins)):
                if curr + coins[i] <= amount:
                    solve(curr + coins[i], i)

        solve(0,0)

        return combinations
    
# Tabulation Approach

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:

        # dp[i] is the number of ways to make the amount i 
        # we'll need to return dp[amount]

        dp = [0] * (amount+1)

        dp[0] = 1 

        for coin in coins:
            for i in range(coin, amount+1):
                dp[i] += dp[i-coin]
        
        return dp[amount]
 


