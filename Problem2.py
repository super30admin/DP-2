## Problem2 (https://leetcode.com/problems/coin-change-2/)


# Time Complexity : O(Amount * Coins)
# Space Complexity : O(Amount * Coins) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

#Approach: Keep array list, count at the current index + amount - current coin

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        dp = [0] * (amount + 1)
        dp[0] = 1
        for i in coins:
            for j in range(i, amount + 1):
                dp[j] += dp[j - i]
        return dp[-1]
    