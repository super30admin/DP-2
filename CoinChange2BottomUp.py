'''
TC: O(m*n) where m is no. of coins and n is the amount
SC: O(n) 1d array for amount
'''
from typing import List

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        res = [0]*(amount+1)
        res[0] = 1
        for coin in coins:
            for i, v in enumerate(res):
                if i>=coin:
                    res[i] = res[i]+res[i-coin]
        return res[-1]
s = Solution()
print(s.change(5, [1,2,5]))
print(s.change(3, [2]))
print(s.change(10, [10]))
print(s.change(500, [3,5,7,8,9,10,11]))