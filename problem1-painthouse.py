#time - o(n*m) n number of house and m number of colors
#space -- o(n*m)

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:

        if len(costs) == 0 or costs == None:
            return 0
        matrix = [[0 for i in range(3)] for j in range(len(costs))]
        for i in range(len(costs)):
            if i == 0:
                matrix[i][0] = costs[i][0]
                matrix[i][1] = costs[i][1]
                matrix[i][2] = costs[i][2]
                continue
            matrix[i][0] = costs[i][0] + min(matrix[i-1][1], matrix[i-1][2])
            matrix[i][1] = costs[i][1] + min(matrix[i-1][0], matrix[i-1][2])
            matrix[i][2] = costs[i][2] + min(matrix[i-1][0], matrix[i-1][1])
        return min(matrix[len(costs)-1][0],matrix[len(costs)-1][1],matrix[len(costs)-1][2])