'''
Time Complexity - O(n) where n is number of house
Space Complexity = O(1) 
'''


class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        n = len(costs)
        rCost = costs[n-1][0]
        bCost = costs[n-1][1]
        gCost = costs[n-1][2]
        for i in range(n-2, -1, -1):
            rTemp = rCost
            bTemp = bCost
            gTemp = gCost
            rCost = costs[i][0] + min(bTemp, gTemp)
            bCost = costs[i][1] + min(rTemp, gTemp)
            gCost = costs[i][2] + min(rTemp, bTemp)
        return min(rCost, bCost, gCost)
