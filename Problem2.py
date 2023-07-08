# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        n=len(costs)
        matrix=[0 for i in range(3)]
        CostR=costs[n-1][0]
        CostG=costs[n-1][1]
        CostB=costs[n-1][2]

        for i in range(n-2,-1,-1):
            temp1=CostR
            CostR=costs[i][0]+min(CostG,CostB)
            temp2=CostG
            CostG=costs[i][1]+min(temp1,CostB)
            CostB=costs[i][2]+min(temp2,temp1)
        

        return min(CostR,CostG,CostB)
