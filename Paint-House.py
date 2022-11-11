class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if not costs:
            return 0
        
        for i in range(len(costs) - 2, -1, -1):
            for j in range(len(costs[i])):
                if j == 0:
                    costs[i][j] += min(costs[i+1][j+1], costs[i+1][j+2])
                elif j == 1:
                    costs[i][j] += min(costs[i+1][j-1], costs[i+1][j+1])
                elif j == 2:
                    costs[i][j] += min(costs[i+1][j-2], costs[i+1][j-1])
                           
        min_cost = min(costs[0][0], costs[0][1], costs[0][2])
                           
        return min_cost
