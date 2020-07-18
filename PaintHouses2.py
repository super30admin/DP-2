#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Thu Nov 28 08:55:46 2019

@author: tanvirkaur
"""

# Recursive solution
# Time complexity = 3*O(2^n)
class Solution(object):
    def minCost(self,costs):
        if not costs:
            return 0
        amount = float('inf')
        for j in range(0,3):
            amount = min(amount,self.helper(costs,0,j,0))
        return amount
        
        
        
    def helper(self,costs,i,j,amount):
        if i == len(costs):
            return amount
        case1 = 0
        case2 = 0
        if j == 0:
            case1 += self.helper(costs,i+1,1,amount+costs[i][1])
            case2 += self.helper(costs,i+1,2,amount+costs[i][2])
            
        if j == 1:
            case1 += self.helper(costs,i+1,0,amount+costs[i][0])
            case2 += self.helper(costs,i+1,2,amount+costs[i][2])
        if j == 2:
            case1 += self.helper(costs,i+1,0,amount+costs[i][0])
            case2 += self.helper(costs,i+1,1,amount+costs[i][1])
        return min(case1,case2)

obj = Solution()
costs = [[17,2,17],[16,16,5],[14,3,19]]
print(obj.minCost(costs))
            