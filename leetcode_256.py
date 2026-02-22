#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sun Feb 22 13:19:10 2026

@author: rishigoswamy

    Problem:
    Each house can be painted Red, Green, or Blue.
    No two adjacent houses can have the same color.
    Return the minimum total cost.

    Approach:
    Dynamic Programming.
    For each house:
        cost[color] = current cost +
                      minimum of previous house's other two colors

    Time Complexity: O(n)
    Space Complexity: O(1)
        
"""

from typing import List

#https://leetcode.com/problems/paint-house/
class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        currCost = costs[0]
        val = min(costs[0])
        for i in range(1, len(costs)):
            costR = costs[i][0] + min(currCost[1], currCost[2])
            costG = costs[i][1] + min(currCost[0], currCost[2])
            costB = costs[i][2] + min(currCost[1], currCost[0])
            val = min(costR, costG, costB)
            currCost = [costR, costG, costB]
        return val