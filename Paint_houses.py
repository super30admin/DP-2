class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        for i in range(1,len(costs)):
            for j in range(3):
                if j == 2:
                    costs[i][j] = costs[i][j] + min(costs[i-1][j-1],costs[i-1][0])
                else:
                    costs[i][j] = costs[i][j] + min(costs[i-1][j-1],costs[i-1][j+1])
        return min(costs[-1])