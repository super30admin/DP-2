'''
The brute force is to make a tree of choosing a coin or not and keep traversing
until the amount is reached. The branches that reach the amount are the total
number of ways to reach the amount.
Space complexity: O(amount/min(coins))
Time complexity: O(2^(amount/min(coins)))

This produces repeated nodes and hence dp can be used.

The number of ways to reach 3 using coins[1,2] is
1. 1+1+1
2. 1+2

Which can be also seen as:
1. Number of ways to reach 3 using 1s
2. Number of ways to reach 3 using 2s and 1s.
    - This can be further broken down into:
        1) Number of ways to reach 1 using 1s and 2s and then using a coin of 2
        This keeps the number of ways to reach 3 same as number of ways to reach 1.

We formulate this into a table and iterate over the whole table to find the final number
of ways to reach the amount using all the given coins.

Time complexity: O(amount * len(coins))
Space complexity: O(amount * len(coins))
'''

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        dp = [ 0 for _ in range(amount+1)]
        dp[0] = 1

        for coin in coins:
            for total in range(amount+1):
                if total >= coin:
                    dp[total] = dp[total] + dp[total-coin]
        
        return dp[-1]