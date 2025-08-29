# Time Complexity : O(M*N) 
# Space Complexity : O(N) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach:
# I have a dp array which represents the number of ways to make change for amount i.
# I check if the amount has been reached by any combination of coins if it has I update the array
# I return the total ways to make change for the given amount.

from typing import List
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        dp = [0] * (amount + 1)
        dp[0] = 1
        for i in range(1,len(coins)+1):
            for j in range(coins[i-1],amount + 1):
                dp[j] += dp[j - coins[i-1]]
        return dp[amount]
        