"""
Time Complexity : O(2^n)
Space Complexity : O(n)
Did this code successfully run on Leetcode : Time Limit Exceeded
Any problem you faced while coding this : No
"""
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        if len(coins) == 0:
            return 0
        return self.helper(coins, amount, 0)
    def helper(self, coins: List[int], amount: int, index: int):
        # Base
        if amount == 0:
            return 1
        if amount < 0 or index == len(coins):
            return 0
        # Logic
        # Don't choose case
        case1 = self.helper(coins, amount, index + 1)
        
        # Choose case
        case2 = self.helper(coins, amount - coins[index], index)
        return case1 + case2