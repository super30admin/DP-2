class Solution:
    def minCost(self, costs) -> int:
        costR,costB,costG=costs[len(costs)-1][0],costs[len(costs)-1][1],costs[len(costs)-1][2]
        for i in range(len(costs)-2,-1,-1):
            tempR=costR
            tempB=costB
            costR=costs[i][0]+min(costB,costG)
            costB=costs[i][1]+min(tempR,costG)
            costG=costs[i][2]+min(tempR,tempB)
        return min(costR,costB,costG)