# Time Complexity : O(m*n) 
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

from typing import List

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        m = len(costs)
        n = len(costs[0])
        colorR = costs[m-1][0]
        colorB = costs[m-1][1]
        colorG = costs[m-1][2]
        
        for i in range(m-2, -1, -1):
            tempR = colorR
            tempB = colorB
            colorR = costs[i][0]+ min(colorB, colorG)
            colorB = costs[i][1]+ min(tempR, colorG)
            colorG = costs[i][2]+ min(tempR, tempB)
        return min(colorR, colorB, colorG)