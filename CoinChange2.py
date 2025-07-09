# Time Complexity : It is O(n*m) looping through coins and amount.
# Space Complexity : It is O(n*m) we need to calculate the different permutation.
# Did this code successfully run on Leetcode :
# Any problem you faced while coding this :

import numpy as np
from typing import List

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        
        coinAmountMap = np.full([len(coins) + 1,amount +1], 0)
        
        for zeroCol in range(len(coins)+1):
            coinAmountMap[zeroCol][0]=1
        
        
        
        for coin in range(1, len(coins)+1):
            for amt in range(1, (amount+1)):
                if amt < coins[coin-1]:
                    coinAmountMap[coin][amt] = coinAmountMap[coin-1][amt]
                else:
                    coinAmountMap[coin][amt] = coinAmountMap[coin-1][amt] + coinAmountMap[coin][amt-coins[coin-1]]
                    
        if coinAmountMap[len(coins), amount] == 0:
            return 0
        else:
            return coinAmountMap[len(coins), amount]

obj = Solution()
print(obj.change(5,[1,2,5]))