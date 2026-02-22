#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sun Feb 22 13:21:36 2026

@author: rishigoswamy

        
    Problem:
    #https://leetcode.com/problems/coin-change-ii/description/
    
    Count number of combinations to make 'amount'
    using unlimited supply of given coins.

    Approach:
    2D Dynamic Programming

    dp[i][j] =
        number of ways to make amount j
        using first i coins

    Time Complexity: O(n * amount)
    Space Complexity: O(n * amount)
    
"""


from typing import List
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        dp = [[0] * (amount + 1) for _ in range(len(coins)+1)]

        for i in range(0, len(dp)):
            dp[i][0] = 1

        for i in range(1,len(dp)):
            for j in range(len(dp[0])):
                currCoin = coins[i-1]
                dp[i][j] = dp[i-1][j]
                if j-currCoin >= 0:
                    dp[i][j] += dp[i][j-currCoin]
        return dp[-1][-1]
