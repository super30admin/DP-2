'''
TC: O(2^(m+n)) where (m+n) is the height of the tree
    m: successful cases and n: non successfull cases
SC: O(m+n) since the recursive calls occupy stack space internally
'''
from typing import List

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        self.count = 0

        def helper(amount, idx):
            #base
            if amount ==0:
                self.count += 1
                return 
            if amount < 0 or idx >= len(coins):
                return

            #logic
            #not choose
            helper(amount, idx+1)
            #choose
            helper(amount-coins[idx], idx)

        helper(amount, 0)
        return self.count
s = Solution()
print(s.change(5, [1,2,5]))
print(s.change(3, [2]))
print(s.change(10, [10]))
# print(s.change(500, [3,5,7,8,9,10,11])) # Gives time limit exceeded as expected