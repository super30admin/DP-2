# TC: O(n), where n => no. of houses
# SC : O(n * m), where n => no. of houses, m => colors

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if costs == None:
            return 0
        n = len(costs)
        costR = costs[n-1][0]
        costB = costs[n-1][1]
        costG = costs[n-1][2]

        for i in range(n-2, -1, -1):
            tempR = costR
            tempB = costB

            costR = costs[i][0] + min(tempB, costG)
            costB = costs[i][1] + min(tempR, costG)
            costG = costs[i][2] + min(tempR, tempB)

        return min(costR, costB, costG)
        