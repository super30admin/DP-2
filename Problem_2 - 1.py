"""
Coin Change - 2

Time Complexity : O(2^n)
Space Complexity : O(m+n)
    
"""


class Solution:
    def helper(self, amount, coins, index):
        if amount == 0:
            return 1 
        if amount < 0 or index == len(coins):
            return 0 
        
        case1 = self.helper(amount - coins[index], coins, index)
        case2 = self.helper(amount, coins, index + 1)
        
        return case1 + case2
        
    def change(self, amount: int, coins: List[int]) -> int:
        if not coins or len(coins) == 0:
            return 0 
        
        return self.helper(amount, coins, 0)