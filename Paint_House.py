
class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        
        colorR, colorB, colorG = costs[0][0],costs[0][1],costs[0][2]
        
        for i in range(1,len(costs)):
            tempR = colorR
            tempB = colorB
            colorR = costs[i][0] + min(colorB, colorG)
            colorB = costs[i][1] + min(tempR, colorG)
            colorG = costs[i][2] + min(tempR, tempB)
        return min(colorR,colorG, colorB)