#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Thu Nov 28 08:31:08 2019

@author: tanvirkaur
"""
#time complexity = O(n*m) = O(3n)
#Space complexity = O(1)

class Solution(object):
    def minCost(self,costs):
        for i in range(1,len(costs)):
            costs[i][0] = costs[i][0] + min(costs[i-1][1], costs[i-1][2])
            costs[i][1] = costs[i][1] + min(costs[i-1][0], costs[i-1][2])
            costs[i][2] = costs[i][2] + min(costs[i-1][1], costs[i-1][0])
        return min(costs[len(costs)-1][0],costs[len(costs)-1][1],costs[len(costs)-1][1])
    
obj = Solution()
costs = [[17,2,17],[16,16,5],[14,3,19]]
print(obj.minCost(costs))