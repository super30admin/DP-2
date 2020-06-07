# Time Complexity : O(2^n * k) [n = number of coins, k = amount]
# 
# Space Complexity : O(2^n * k) [stack space used]
# 
# Did this code successfully run on Leetcode : Partially(TLE)
# 
# Any problem you faced while coding this : No
#
# Problem Approach
# 1. At each recursive call we pass the index of the coin. We can explore two options-
#   1.1 Choose the coin and deduct from the amount
#   1.2 Do not choose the coin and move to the next coin index
# 2. We explore all the possible using the above approach and take in to account only the path which reduces the amount to exactly 0
class Solution:
    def changeUtil(self, amount, coins, index):
        # base
        if amount < 0 or index >= len(coins):
            return 0
        if amount == 0:
            return 1
        
        # body
        case_0 = self.changeUtil(amount, coins, index+1)
        case_1 = self.changeUtil(amount - coins[index], coins, index)
        
        return case_0 + case_1
        
    def change(self, amount: int, coins: List[int]) -> int:
        if amount==0:return 1
        return self.changeUtil(amount, coins, 0)