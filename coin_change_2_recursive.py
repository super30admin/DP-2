# Time Complexity : O(m^n) where is m is number of coins and n = amount / min(coins)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : No (Time Limit Exceeded)
# Any problem you faced while coding this : No

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        return self.changeHelper(amount, coins, 0)
    
    def changeHelper(self, amount, coins, index):
        # Base Case
        if amount == 0: return 1
        if amount < 0 or index == len(coins): return 0
        
        #Logic:
        # Choose case
        case1 = self.changeHelper(amount - coins[index] , coins, index)
        
        #Not Choose case
        case2 = self.changeHelper(amount, coins, index + 1)
        
        return case1 + case2