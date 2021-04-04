# -*- coding: utf-8 -*-
"""
Created on Sun Apr  4 11:14:15 2021

@author: jgdch
"""

#Space Complexity, O(N) where N is the length of dp array which is nothing but the amount
#Time Compleixty, O(N*amount)
class Solution(object):
    def change(self, amount, coins):
        """
        :type amount: int
        :type coins: List[int]
        :rtype: int
        """
        dp = [0] * (amount + 1)
        dp[0] = 1
        
        for coin in coins:
            for i in range(coin, amount + 1):
                dp[i] +=dp[i - coin] 
        return dp[amount]      
        