# Time Complexity: O(m); no. of houses= m
# Space Complexity: O(1);

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        
        m = len(costs)
        colorR = costs[m-1][0]
        colorB = costs[m-1][1]
        colorG = costs[m-1][2]
        
        for i in range(len(costs)-2, -1, -1):
            tempR = colorR
            tempB = colorB
            colorR = costs[i][0] + min(colorG, colorB)
            colorB = costs[i][1] + min(tempR, colorG)
            colorG = costs[i][2] + min(tempR, tempB)
        
        return min(colorR, colorB, colorG)
        
