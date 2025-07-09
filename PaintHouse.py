# Time Complexity : It is O(n) looping through List.
# Space Complexity : No extra space O(1).
# Did this code successfully run on Leetcode :
# Any problem you faced while coding this :

from typing import List

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        rowLen = len(costs)-1
        totalRedCost =0
        totalBlueCost =0
        totalGreenCost =0
        minCost= 0
        for i in range(rowLen,-1,-1):
            
            rowR= min(costs[i][1] + totalBlueCost,costs[i][2]+ totalGreenCost)
            rowB= min(costs[i][0] + totalRedCost,costs[i][2]+ totalGreenCost)
            rowG= min(costs[i][0]+ totalRedCost,costs[i][1]+ totalBlueCost)
            
            totalRedCost = rowR
            totalBlueCost = rowB
            totalGreenCost = rowG
        
        print (minCost)
        return min(totalBlueCost,totalGreenCost,totalRedCost)
        
        
obj = Solution()
print(obj.minCost([[3,5,3],[6,17,6],[7,13,18],[9,10,18]]))
# print(obj.minCost([[17,2,17],[16,16,5],[14,3,19]]))
# print(obj.minCost([[7,6,2]]))